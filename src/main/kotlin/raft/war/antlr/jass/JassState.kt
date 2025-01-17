package raft.war.antlr.jass

import org.antlr.v4.runtime.BaseErrorListener
import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.RecognitionException
import org.antlr.v4.runtime.Recognizer
import org.antlr.v4.runtime.atn.ATNConfigSet
import org.antlr.v4.runtime.dfa.DFA
import raft.war.antlr.grammar.Jass.JassBaseVisitor
import raft.war.antlr.grammar.Jass.JassLexer
import raft.war.antlr.grammar.Jass.JassParser
import raft.war.antlr.grammar.Jass.JassParser.*
import raft.war.antlr.jass.error.JassError
import raft.war.antlr.jass.error.JassErrorId
import raft.war.antlr.jass.psi.*
import java.util.BitSet

class JassState : JassBaseVisitor<IJassNode>() {

    var states: List<JassState> = listOf()

    val natives: MutableList<JassFun> = mutableListOf()
    val globals: MutableList<JassVar> = mutableListOf()
    val functions: MutableList<JassFun> = mutableListOf()

    val mapNode: MutableMap<String, IJassNode> = mutableMapOf()
    fun getNode(key: String, f: JassFun?): IJassNode? {
        if (f != null) {
            for (p in f.param.asReversed()) {
                if (p.name == key) return p
            }
        }
        states.forEach {
            if (it.mapNode.containsKey(key)) {
                return it.mapNode[key]
            }
        }
        if (mapNode.containsKey(key)) {
            return mapNode[key]
        }
        return null
    }

    val mapType: MutableMap<String, JassHandleType> = mutableMapOf()
    val types: MutableList<JassHandleType> = mutableListOf()

    fun getType(key: String): IJassType? {
        var type: IJassType? = null
        states.forEach {
            if (it.mapType.containsKey(key)) {
                type = it.mapType[key]
            }
        }
        if (mapType.containsKey(key)) {
            type = mapType[key]
        }
        return type

    }

    fun typeFromString(str: String): IJassType = when (str) {
        "integer" -> JassIntType()
        "real" -> JassRealType()
        "string" -> JassStrType()
        "boolean" -> JassBoolType()
        "code" -> JassCodeType()
        "handle" -> JassHandleType(str)
        else -> getType(str) ?: JassUndefinedType()
    }

    private fun typedef(ctx: TypeContext) {
        val parent = ctx.extends_().typename().text

        val type = JassHandleType(ctx.typename().text)

        var p = mapType[parent]
        if (parent == "handle" && p == null) {
            p = JassHandleType("handle")
            mapType[parent] = p
            types.add(p)
        }

        if (p == null) {
            errors.add(JassError(JassErrorId.TYPE_DEF, ctx.start.line, 0, "${type.name} !extend $parent"))
            return
        }

        type.parent = p
        mapType[type.name] = type
        types.add(type)
    }

    private fun global(ctx: VariableContext) {
        val v = JassVar(
            name = ctx.varname().text,
            constant = ctx.CONSTANT() != null,
            array = ctx.ARRAY() != null,
            global = true,
            type = typeFromString(ctx.typename().text),
        )

        if (ctx.EQ() != null) {
            v.expr = expr(ctx.expr(), null)
            if (v.expr == null) {
                errors.add(JassError(JassErrorId.ERROR, ctx.start.line, 0, "⚠️ ${v.name} global set missing"))
            } else {
                val ta: IJassType = v.type
                val tb: IJassType = v.expr!!.type
                val t = ta.op(JassExprOp.Set, tb)
                if (t is JassUndefinedType) {
                    errors.add(JassError(JassErrorId.TYPE_CAST, ctx.start.line, 0, "$ta ${JassExprOp.Set} $tb is $t"))
                }
            }
        }

        if (getNode(v.name, null) != null) {
            errors.add(JassError(JassErrorId.REDECLARED, ctx.start.line, 0, v.name))
            return
        }

        mapNode[v.name] = v
        globals.add(v)
    }

    fun returns(f: JassFun, ctx: Returns_Context) {
        if (ctx.NOTHING() != null) return
        val t = ctx.ID().text
        f.type = typeFromString(t)
        if (f.type is JassUndefinedType) errors.add(
            JassError(
                JassErrorId.TYPE_DEF,
                ctx.start.line,
                0,
                "type $t not exists"
            )
        )
    }

    fun native(ctx: NativeContext) {
        val f = JassFun(
            name = ctx.ID().text,
            native = true
        )

        if (getNode(f.name, null) != null) {
            errors.add(JassError(JassErrorId.REDECLARED, ctx.start.line, 0, "${f.name} redeclared"))
            return
        }

        val takes = ctx.takes()
        if (takes.NOTHING() == null) {
            for (it in takes.params().param()) {
                f.param.add(
                    JassVar(
                        name = it.varname().text,
                        type = typeFromString(it.typename().text),
                        local = true,
                        param = true,
                    )
                )
            }
        }

        returns(f, ctx.returns_())

        mapNode[f.name] = f
        natives.add(f)
    }

    fun expr(ctx: ExprContext?, f: JassFun?): JassExpr? {
        if (ctx == null) return null

        when (ctx) {
            is ExprFunContext -> {
                val name = ctx.ID().text
                val cf = JassFun(
                    name = name,
                    type = JassCodeType(),
                    ref = true,
                )

                return JassExpr(
                    op = JassExprOp.Get,
                    a = cf
                )
            }

            is ExprCallContext -> {
                val name = ctx.ID().text
                val node = getNode(name, f)
                if (node !is JassFun) {
                    errors.add(JassError(JassErrorId.ERROR, ctx.start.line, 0, "[call] $name is not a function"))
                    return null
                }
                val cf = node.clone()

                ctx.expr().forEach {
                    val e = expr(it, f)
                    if (e != null) {
                        cf.arg.add(e)
                    }
                }

                return JassExpr(
                    op = JassExprOp.Get,
                    a = cf
                )
            }

            is ExprVarContext -> {
                val name = ctx.text
                var node: IJassNode? = getNode(name, f)
                if (node is JassVar) {
                    return JassExpr(op = JassExprOp.Get, a = node.clone())
                }
                errors.add(JassError(JassErrorId.ERROR, ctx.start.line, 0, "$name is not declared"))
                //println("🍒 ${ctx.start.line} $name | ${f?.param}")
                return null
            }

            is ExprArrContext -> {
                val name = ctx.ID().text
                var node: IJassNode? = getNode(name, f)
                if (node !is JassVar) {
                    errors.add(JassError(JassErrorId.ERROR, ctx.start.line, 0, "$name array is not declared"))
                    return null
                }
                return JassExpr(
                    op = JassExprOp.Get,
                    a = node.clone(
                        index = expr(ctx.expr(), f)
                    )
                )
            }

            is ExprUnContext -> return JassExpr(
                op = when (true) {
                    (ctx.MINUS() != null) -> JassExprOp.UnSub
                    (ctx.NOT() != null) -> JassExprOp.UnNot
                    else -> return null
                },
                a = expr(ctx.expr(), f),
            )

            is ExprIntContext -> return JassExpr(op = JassExprOp.Get, a = JassInt(ctx.text))
            is ExprStrContext -> return JassExpr(op = JassExprOp.Get, a = JassStr(ctx.text))
            is ExprBoolContext -> return JassExpr(op = JassExprOp.Get, a = JassBool(ctx.text))
            is ExprRealContext -> return JassExpr(op = JassExprOp.Get, a = JassReal(ctx.text))
            is ExprNullContext -> return JassExpr(op = JassExprOp.Get, a = JassNull())

            is ExprParenContext -> return JassExpr(op = JassExprOp.Paren, a = expr(ctx.expr(), f))

            // 3
            is ExprMulContext -> return JassExpr(
                op = when (true) {
                    (ctx.MUL() != null) -> JassExprOp.Mul
                    (ctx.DIV() != null) -> JassExprOp.Div
                    else -> return null
                },
                a = expr(ctx.expr(0), f),
                b = expr(ctx.expr(1), f)
            )

            // 4
            is ExprAddContext -> return JassExpr(
                op = when (true) {
                    (ctx.PLUS() != null) -> JassExprOp.Add
                    (ctx.MINUS() != null) -> JassExprOp.Sub
                    else -> return null
                },
                a = expr(ctx.expr(0), f),
                b = expr(ctx.expr(1), f)
            )

            // 5
            is ExprLtContext -> return JassExpr(
                op = when (true) {
                    (ctx.LT() != null) -> JassExprOp.Lt
                    (ctx.LT_EQ() != null) -> JassExprOp.LtEq
                    (ctx.GT() != null) -> JassExprOp.Gt
                    (ctx.GT_EQ() != null) -> JassExprOp.GtEq
                    else -> return null
                },
                a = expr(ctx.expr(0), f),
                b = expr(ctx.expr(1), f)
            )

            // 6
            is ExprEqContext -> return JassExpr(
                op = when (true) {
                    (ctx.EQ_EQ() != null) -> JassExprOp.Eq
                    (ctx.NEQ() != null) -> JassExprOp.Neq
                    else -> return null
                },
                a = expr(ctx.expr(0), f),
                b = expr(ctx.expr(1), f)
            )

            // 7
            is ExprAndContext -> return JassExpr(
                op = when (true) {
                    (ctx.AND() != null) -> JassExprOp.And
                    (ctx.OR() != null) -> JassExprOp.Or
                    else -> return null
                },
                a = expr(ctx.expr(0), f),
                b = expr(ctx.expr(1), f)
            )
        }

        println("🔥Expr: ${ctx.javaClass.name} | ${ctx.text}")
        return null
    }

    fun stmt(ctxs: List<StmtContext>, list: MutableList<IJassNode>, scopes: MutableList<IJassNode>) {
        val f = scopes.first() as JassFun

        for (item in ctxs) {
            when (item) {
                is StmtSetContext -> {
                    val set = item.set()
                    val name = set.ID().text
                    var node = getNode(name, f)

                    if (node !is JassVar) {
                        errors.add(JassError(JassErrorId.ERROR, set.start.line, 0, "[set] $name not exists"))
                        continue
                    }

                    val e = expr(set.expr(), f)
                    if (e == null) {
                        errors.add(
                            JassError(
                                JassErrorId.ERROR,
                                set.start.line,
                                0,
                                "[set] $name no have expression"
                            )
                        )
                        continue
                    }

                    list.add(
                        node.clone(
                            expr = e,
                            index = expr(set.setBrack()?.expr(), f),
                        )
                    )
                    continue
                }

                is StmtCallContext -> {
                    val call = item.call()
                    val name = call.ID().text
                    var node = getNode(name, f)

                    if (node !is JassFun) {
                        errors.add(JassError(JassErrorId.ERROR, call.start.line, 0, "[call] $name not exists"))
                        continue
                    }

                    val cf = JassFun(
                        base = node,
                        call = true,
                        name = name,
                    )

                    call.expr().forEach {
                        val e = expr(it, f)
                        if (e != null) {
                            cf.arg.add(e)
                        }
                    }

                    list.add(cf)
                }

                is StmtLoopContext -> {
                    val l = JassLoop()
                    list.add(l)
                    val ss = scopes.toMutableList()
                    ss.add(l)
                    stmt(item.loop().stmt(), l.stmt, ss)
                }

                is StmtExitWhenContext -> {
                    val exitWhen = item.exitwhen()
                    val exp = expr(exitWhen.expr(), f)
                    if (exp == null) {
                        println("🔥exitwhen no expr")
                    } else {
                        list.add(JassExitWhen(expr = exp))
                    }
                }

                is StmtReturnContext -> {
                    list.add(
                        JassReturn(
                            expr = expr(item.return_().expr(), f),
                        )
                    )
                }

                is StmtIfContext -> {
                    val ctxIf = item.if_()
                    val e = expr(ctxIf.expr(), f)
                    if (e == null) {
                        errors.add(JassError(JassErrorId.ERROR, ctxIf.start.line, 0, "[if] not have expr"))
                        continue
                    }
                    val nodeIf = JassIf(expr = e)
                    list.add(nodeIf)
                    val ss = scopes.toMutableList()
                    ss.add(nodeIf)
                    stmt(ctxIf.stmt(), nodeIf.stmt, ss)

                    for (ctxElseif in ctxIf.elseif()) {
                        val e = expr(ctxIf.expr(), f)
                        if (e == null) {
                            errors.add(JassError(JassErrorId.ERROR, ctxIf.start.line, 0, "[elseif] not have expr"))
                            continue
                        }
                        val nodeElseif = JassIf(expr = e)
                        nodeIf.elseifs.add(nodeElseif)
                        stmt(ctxElseif.stmt(), nodeElseif.stmt, ss)
                    }

                    val ctxElse = ctxIf.else_()
                    if (ctxElse != null) {
                        val elser = JassIf()
                        nodeIf.elser = elser
                        stmt(ctxElse.stmt(), elser.stmt, ss)
                    }
                }

                else -> println("🔥JASS: Missing stmt: ${item.javaClass.name}")
            }
        }
    }

    fun function(ctx: FunctionContext) {
        val f = JassFun(
            name = ctx.ID().text,
        )

        if (getNode(f.name, f) != null) {
            errors.add(JassError(JassErrorId.REDECLARED, ctx.start.line, 0, "${f.name} redeclared function"))
            return
        }

        mapNode[f.name] = f
        functions.add(f)

        val takes: TakesContext = ctx.takes()
        if (takes.NOTHING() == null) {
            for (vctx in takes.params().param()) {
                f.param.add(
                    JassVar(
                        name = vctx.varname().text,
                        type = typeFromString(vctx.typename().text),
                        local = true,
                        param = true,
                    )
                )
            }
        }

        for (vctx: VariableContext in ctx.variable()) {
            val name = vctx.varname().text

            val v = JassVar(
                name = name,
                array = vctx.ARRAY() != null,
                type = typeFromString(vctx.typename().text),
                local = true
            )

            if (vctx.EQ() != null) {
                v.expr = expr(vctx.expr(), f)
                if (v.expr == null) {
                    errors.add(JassError(JassErrorId.ERROR, ctx.start.line, 0, "${f.name} variable without expression"))
                }
            }

            f.param.add(v)
        }

        val params = mutableMapOf<String, JassVar>()
        for (p in f.param.asReversed()) {
            val base = params[p.name]
            if (base == null) {
                params[p.name] = p
            } else {
                p.base = base
            }
        }

        returns(f, ctx.returns_())

        stmt(ctx.stmt(), f.stmt, mutableListOf(f))
    }

    val errors = mutableListOf<JassError>()

    fun parse(stream: CharStream, states: List<JassState> = listOf()) {
        this.states = states

        val errorJassErrorListener = JassErrorListener()

        val lexer = JassLexer(stream)
        lexer.removeErrorListeners()
        lexer.addErrorListener(errorJassErrorListener)

        val tokens = CommonTokenStream(lexer)

        val parser = JassParser(tokens)
        parser.removeErrorListeners()
        parser.addErrorListener(errorJassErrorListener)
        parser.root().accept(this)

        if (errorJassErrorListener.jassErrors.isNotEmpty()) {
            errors.addAll(errorJassErrorListener.jassErrors)
        }
    }

    override fun visitRoot(ctx: RootContext): IJassNode? {
        ctx.children.forEach {
            when (it) {
                is GlobalsContext -> it.variable().forEach(::global)
                is NativeContext -> native(it)
                is TypeContext -> typedef(it)
                is FunctionContext -> function(it)
            }
        }
        return null
    }

    companion object {
        private class JassErrorListener : BaseErrorListener() {
            val jassErrors = mutableListOf<JassError>()

            override fun syntaxError(
                recognizer: Recognizer<*, *>?,
                offendingSymbol: Any?,
                line: Int,
                charPositionInLine: Int,
                msg: String?,
                e: RecognitionException?,
            ) {
                jassErrors.add(
                    JassError(
                        jassErrorId = JassErrorId.SYNTAX,
                        line = line,
                        char = charPositionInLine,
                        message = msg ?: "Unknown error"
                    )
                )
            }

            override fun reportAmbiguity(
                recognizer: Parser?,
                dfa: DFA?,
                startIndex: Int,
                stopIndex: Int,
                exact: Boolean,
                ambigAlts: BitSet?,
                configs: ATNConfigSet?,
            ) {
                if (false) println("[$startIndex, $stopIndex] reportAmbiguity")
            }

            override fun reportAttemptingFullContext(
                recognizer: Parser?,
                dfa: DFA?,
                startIndex: Int,
                stopIndex: Int,
                conflictingAlts: BitSet?,
                configs: ATNConfigSet?,
            ) {
                if (false) println("[$startIndex, $stopIndex] reportAttemptingFullContext")
            }

            override fun reportContextSensitivity(
                recognizer: Parser?,
                dfa: DFA?,
                startIndex: Int,
                stopIndex: Int,
                prediction: Int,
                configs: ATNConfigSet?,
            ) {
                if (false) println("[$startIndex, $stopIndex] reportContextSensitivity")
            }
        }

    }
}
