package io.github.warraft.jass.antlr

import io.github.warraft.jass.antlr.JassParser.CallContext
import io.github.warraft.jass.antlr.JassParser.ElseRuleContext
import io.github.warraft.jass.antlr.JassParser.ElseifContext
import io.github.warraft.jass.antlr.JassParser.ExitwhenContext
import io.github.warraft.jass.antlr.JassParser.ExprAddContext
import io.github.warraft.jass.antlr.JassParser.ExprAndContext
import io.github.warraft.jass.antlr.JassParser.ExprArrContext
import io.github.warraft.jass.antlr.JassParser.ExprBoolContext
import io.github.warraft.jass.antlr.JassParser.ExprCallContext
import io.github.warraft.jass.antlr.JassParser.ExprContext
import io.github.warraft.jass.antlr.JassParser.ExprEqContext
import io.github.warraft.jass.antlr.JassParser.ExprFunContext
import io.github.warraft.jass.antlr.JassParser.ExprIntContext
import io.github.warraft.jass.antlr.JassParser.ExprLtContext
import io.github.warraft.jass.antlr.JassParser.ExprMulContext
import io.github.warraft.jass.antlr.JassParser.ExprNullContext
import io.github.warraft.jass.antlr.JassParser.ExprParenContext
import io.github.warraft.jass.antlr.JassParser.ExprRealContext
import io.github.warraft.jass.antlr.JassParser.ExprStrContext
import io.github.warraft.jass.antlr.JassParser.ExprUnContext
import io.github.warraft.jass.antlr.JassParser.ExprVarContext
import io.github.warraft.jass.antlr.JassParser.FunctionContext
import io.github.warraft.jass.antlr.JassParser.GlobalsContext
import io.github.warraft.jass.antlr.JassParser.IfRuleContext
import io.github.warraft.jass.antlr.JassParser.LoopContext
import io.github.warraft.jass.antlr.JassParser.NativeRuleContext
import io.github.warraft.jass.antlr.JassParser.ReturnRuleContext
import io.github.warraft.jass.antlr.JassParser.ReturnsRuleContext
import io.github.warraft.jass.antlr.JassParser.RootContext
import io.github.warraft.jass.antlr.JassParser.SetContext
import io.github.warraft.jass.antlr.JassParser.StmtCallContext
import io.github.warraft.jass.antlr.JassParser.StmtContext
import io.github.warraft.jass.antlr.JassParser.StmtExitWhenContext
import io.github.warraft.jass.antlr.JassParser.StmtIfContext
import io.github.warraft.jass.antlr.JassParser.StmtLoopContext
import io.github.warraft.jass.antlr.JassParser.StmtReturnContext
import io.github.warraft.jass.antlr.JassParser.StmtSetContext
import io.github.warraft.jass.antlr.JassParser.TakesContext
import io.github.warraft.jass.antlr.JassParser.TypeContext
import io.github.warraft.jass.antlr.JassParser.VariableContext
import io.github.warraft.jass.antlr.error.JassError
import io.github.warraft.jass.antlr.error.JassErrorId
import io.github.warraft.jass.antlr.psi.IJassNode
import io.github.warraft.jass.antlr.psi.IJassType
import io.github.warraft.jass.antlr.psi.JassBool
import io.github.warraft.jass.antlr.psi.JassBoolType
import io.github.warraft.jass.antlr.psi.JassCodeType
import io.github.warraft.jass.antlr.psi.JassExitWhen
import io.github.warraft.jass.antlr.psi.JassExpr
import io.github.warraft.jass.antlr.psi.JassExprOp
import io.github.warraft.jass.antlr.psi.JassFun
import io.github.warraft.jass.antlr.psi.JassHandleType
import io.github.warraft.jass.antlr.psi.JassIf
import io.github.warraft.jass.antlr.psi.JassInt
import io.github.warraft.jass.antlr.psi.JassIntType
import io.github.warraft.jass.antlr.psi.JassLoop
import io.github.warraft.jass.antlr.psi.JassNull
import io.github.warraft.jass.antlr.psi.JassReal
import io.github.warraft.jass.antlr.psi.JassRealType
import io.github.warraft.jass.antlr.psi.JassReturn
import io.github.warraft.jass.antlr.psi.JassStr
import io.github.warraft.jass.antlr.psi.JassStrType
import io.github.warraft.jass.antlr.psi.JassUndefinedType
import io.github.warraft.jass.antlr.psi.JassVar
import org.antlr.v4.runtime.BaseErrorListener
import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.RecognitionException
import org.antlr.v4.runtime.Recognizer
import org.antlr.v4.runtime.atn.ATNConfigSet
import org.antlr.v4.runtime.dfa.DFA

import java.util.BitSet

class JassState {

    var states: List<JassState> = listOf()

    val typeMap: MutableMap<String, JassHandleType> = mutableMapOf()
    val types: MutableList<JassHandleType> = mutableListOf()

    val natives: MutableList<JassFun> = mutableListOf()
    val globals: MutableList<JassVar> = mutableListOf()
    val globalsCtx: MutableList<GlobalsContext> = mutableListOf()

    val functions: MutableList<JassFun> = mutableListOf()

    val nodeMap: MutableMap<String, IJassNode> = mutableMapOf()

    val errors = mutableListOf<JassError>()

    fun getNode(key: String, f: JassFun?): IJassNode? {
        if (f != null) {
            for (p in f.param.asReversed()) {
                if (p.name == key) return p
            }
        }
        states.forEach {
            if (it.nodeMap.containsKey(key)) {
                return it.nodeMap[key]
            }
        }
        if (nodeMap.containsKey(key)) {
            return nodeMap[key]
        }
        return null
    }

    fun getType(key: String): IJassType? {
        var type: IJassType? = null
        states.forEach {
            if (it.typeMap.containsKey(key)) {
                type = it.typeMap[key]
            }
        }
        if (typeMap.containsKey(key)) {
            type = typeMap[key]
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
        val parent = ctx.extendsRule().typename().text

        val type = JassHandleType(ctx.typename().text)

        var p = typeMap[parent]
        if (parent == "handle" && p == null) {
            p = JassHandleType("handle")
            typeMap[parent] = p
            types.add(p)
        }

        if (p == null) {
            errors.add(JassError(JassErrorId.TYPE_DEF, ctx.start.line, 0, "${type.name} !extend $parent"))
            return
        }

        type.parent = p
        typeMap[type.name] = type
        types.add(type)
    }

    private fun global(ctx: VariableContext) {
        val v = JassVar(
            name = ctx.varname().text,
            constant = ctx.CONSTANT() != null,
            array = ctx.ARRAY() != null,
            global = true,
            type = typeFromString(ctx.typename().text),
            ctx = ctx,
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

        nodeMap[v.name] = v
        globals.add(v)
    }

    fun returns(f: JassFun, ctx: ReturnsRuleContext) {
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

    fun native(ctx: NativeRuleContext) {
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

        returns(f, ctx.returnsRule())

        nodeMap[f.name] = f
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
        errors.add(JassError(JassErrorId.ERROR, ctx.start.line, 0, "Undeclared expression"))
        return null
    }

    fun stmt(ctxs: List<StmtContext>, list: MutableList<IJassNode>, scopes: MutableList<IJassNode>) {
        val f = scopes.first() as JassFun

        for (item in ctxs) {
            when (item) {
                is StmtSetContext -> {
                    val setctx: SetContext = item.set()
                    val name = setctx.ID().text
                    var node = getNode(name, f)

                    if (node !is JassVar) {
                        errors.add(JassError(JassErrorId.ERROR, setctx.start.line, 0, "[set] $name not exists"))
                        continue
                    }

                    val e = expr(setctx.expr(), f)
                    if (e == null) {
                        errors.add(
                            JassError(
                                JassErrorId.ERROR,
                                setctx.start.line,
                                0,
                                "[set] $name no have expression"
                            )
                        )
                        continue
                    }

                    list.add(
                        node.clone(
                            expr = e,
                            index = expr(setctx.setBrack()?.expr(), f),
                            ctx = item,
                        )
                    )
                    continue
                }

                is StmtCallContext -> {
                    val callctx: CallContext = item.call()
                    val name = callctx.ID().text
                    var node = getNode(name, f)

                    if (node !is JassFun) {
                        errors.add(JassError(JassErrorId.ERROR, callctx.start.line, 0, "[call] $name not exists"))
                        continue
                    }

                    val cf = node.clone(
                        call = true,
                        ctx = callctx,
                    )

                    callctx.expr().forEach {
                        val e = expr(it, f)
                        if (e != null) {
                            cf.arg.add(e)
                        }
                    }

                    list.add(cf)
                }

                is StmtLoopContext -> {
                    val loopctx: LoopContext = item.loop()
                    val l = JassLoop(ctx = loopctx)
                    list.add(l)
                    val ss = scopes.toMutableList()
                    ss.add(l)
                    stmt(loopctx.stmt(), l.stmt, ss)
                }

                is StmtExitWhenContext -> {
                    val ewhenctx: ExitwhenContext = item.exitwhen()
                    val exp = expr(ewhenctx.expr(), f)
                    if (exp == null) {
                        errors.add(JassError(JassErrorId.ERROR, ewhenctx.start.line, 0, "exitwhen without expression"))
                    } else {
                        list.add(
                            JassExitWhen(
                                expr = exp,
                                ctx = ewhenctx,
                            )
                        )
                    }
                }

                is StmtReturnContext -> {
                    val rctx: ReturnRuleContext = item.returnRule()
                    val e = expr(rctx.expr(), f)
                    if (e != null) {
                        val v = e.a
                        if (v is JassVar) {
                            if (v.array) {
                                errors.add(JassError(JassErrorId.RETURN_ARRAY, rctx.start.line, 0, "return array"))
                            }
                        }
                    }
                    list.add(
                        JassReturn(
                            expr = e,
                            ctx = rctx,
                        )
                    )
                }

                is StmtIfContext -> {
                    val ifcxt: IfRuleContext = item.ifRule()
                    val e = expr(ifcxt.expr(), f)
                    if (e == null) {
                        errors.add(JassError(JassErrorId.ERROR, ifcxt.start.line, 0, "[if] not have expr"))
                        continue
                    }
                    val nodeIf = JassIf(expr = e, ctx = ifcxt)
                    list.add(nodeIf)
                    val ss = scopes.toMutableList()
                    ss.add(nodeIf)
                    stmt(ifcxt.stmt(), nodeIf.stmt, ss)

                    for (elseifctx: ElseifContext in ifcxt.elseif()) {
                        val e = expr(ifcxt.expr(), f)
                        if (e == null) {
                            errors.add(JassError(JassErrorId.ERROR, ifcxt.start.line, 0, "[elseif] not have expr"))
                            continue
                        }
                        val nodeElseif = JassIf(expr = e, ctx = elseifctx)
                        nodeIf.elseifs.add(nodeElseif)
                        stmt(elseifctx.stmt(), nodeElseif.stmt, ss)
                    }

                    val elsectx: ElseRuleContext? = ifcxt.elseRule()
                    if (elsectx != null) {
                        val elser = JassIf(ctx = elsectx)
                        nodeIf.elser = elser
                        stmt(elsectx.stmt(), elser.stmt, ss)
                    }
                }

                else -> {
                    errors.add(JassError(JassErrorId.REDECLARED, item.start.line, 0, "Udeclared statement"))
                }
            }
        }
    }

    fun function(ctx: FunctionContext) {
        val f = JassFun(
            name = ctx.ID().text,
            ctx = ctx,
        )

        if (getNode(f.name, f) != null) {
            errors.add(JassError(JassErrorId.REDECLARED, ctx.start.line, 0, "${f.name} redeclared function"))
            return
        }

        nodeMap[f.name] = f
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
                        ctx = vctx,
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
                local = true,
                ctx = vctx,
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

        returns(f, ctx.returnsRule())

        stmt(ctx.stmt(), f.stmt, mutableListOf(f))
    }

    fun root(ctx: RootContext): IJassNode? {
        ctx.children.forEach {
            when (it) {
                is GlobalsContext -> {
                    globalsCtx.add(it)
                    it.variable().forEach(::global)
                }

                is NativeRuleContext -> native(it)
                is TypeContext -> typedef(it)
                is FunctionContext -> function(it)
            }
        }
        return null
    }

    fun parse(stream: CharStream, states: List<JassState> = listOf()) {
        this.states = states

        types.clear()
        typeMap.clear()
        natives.clear()
        globals.clear()
        globalsCtx.clear()
        functions.clear()
        nodeMap.clear()
        errors.clear()

        val errorJassErrorListener = JassErrorListener()

        val lexer = JassLexer(stream)
        lexer.removeErrorListeners()
        lexer.addErrorListener(errorJassErrorListener)

        val tokens = CommonTokenStream(lexer)

        val parser = JassParser(tokens)
        parser.removeErrorListeners()
        parser.addErrorListener(errorJassErrorListener)
        root(parser.root())

        if (errorJassErrorListener.jassErrors.isNotEmpty()) {
            errors.addAll(errorJassErrorListener.jassErrors)
        }
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
                        id = JassErrorId.SYNTAX,
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
            }

            override fun reportAttemptingFullContext(
                recognizer: Parser?,
                dfa: DFA?,
                startIndex: Int,
                stopIndex: Int,
                conflictingAlts: BitSet?,
                configs: ATNConfigSet?,
            ) {
            }

            override fun reportContextSensitivity(
                recognizer: Parser?,
                dfa: DFA?,
                startIndex: Int,
                stopIndex: Int,
                prediction: Int,
                configs: ATNConfigSet?,
            ) {
            }
        }

    }
}
