package raft.war.antlr.jass

import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import raft.war.antlr.grammar.Jass.JassBaseVisitor
import raft.war.antlr.grammar.Jass.JassLexer
import raft.war.antlr.grammar.Jass.JassParser
import raft.war.antlr.grammar.Jass.JassParser.*
import raft.war.antlr.jass.error.JassError
import raft.war.antlr.jass.error.JassErrorId
import raft.war.antlr.jass.error.JassErrorListener
import raft.war.antlr.jass.psi.*
import kotlin.math.exp

class JassState : JassBaseVisitor<IJassNode>() {
    var states: List<JassState> = listOf()

    val natives: MutableList<JassFun> = mutableListOf()
    val globals: MutableList<JassVar> = mutableListOf()
    val functions: MutableList<JassFun> = mutableListOf()

    val mapNode: MutableMap<String, IJassNode> = mutableMapOf()
    fun getNode(key: String, f: JassFun?): IJassNode? {
        var node: IJassNode? = null
        if (f != null) {
            for (p in f.param.asReversed()) {
                if (p.name == key) return p
            }
        }

        states.forEach {
            if (it.mapNode.containsKey(key)) {
                node = it.mapNode[key]
            }
        }
        if (mapNode.containsKey(key)) {
            node = mapNode[key]
        }
        return node
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
            type = typeFromString(ctx.typename().text)
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

    fun takes(f: JassFun, ctx: TakesContext) {
        if (ctx.NOTHING() != null) return

        ctx.params().param().forEach {
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

        takes(f, ctx.takes())
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
                val cf = JassFun(
                    name = name,
                )

                val node = getNode(name, null)
                if (node is JassFun) {
                    cf.type = node.type

                }

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

        println("🔥Expr: ${ctx.javaClass.name} | ${ctx.text}")
        return null
    }

    fun stmt(ctxs: List<StmtContext>, scopes: MutableList<IJassStmtBlock>) {
        val f = scopes.first() as JassFun

        val scope = scopes.last()

        for (item: StmtContext in ctxs) {

            val ifctx: IfContext? = item.if_()
            if (ifctx != null) {
                val e = expr(ifctx.expr(), f)
                if (e == null) {
                    errors.add(JassError(JassErrorId.ERROR, ifctx.start.line, 0, "[if] not have expr"))
                    continue
                }
                val i = JassIf(
                    mode = JassIfMode.If,
                    expr = e
                )
                scope.stmt.add(i)
                val ss = scopes.toMutableList()
                ss.add(i)
                stmt(ifctx.stmt(), ss)
            }

            val set: SetContext? = item.set()
            if (set != null) {
                val name = set.ID().text
                var node = getNode(name, f)

                if (node !is JassVar) {
                    errors.add(JassError(JassErrorId.ERROR, set.start.line, 0, "[set] $name not exists"))
                    continue
                }

                val e = expr(set.expr(), f)
                if (e == null) {
                    errors.add(JassError(JassErrorId.ERROR, set.start.line, 0, "[set] $name no have expression"))
                    continue
                }

                scope.stmt.add(
                    node.clone(
                        expr = e,
                        index = expr(set.setBrack()?.expr(), f),
                    )
                )
            }

            val loop: LoopContext? = item.loop()
            if (loop != null) {
                val l = JassLoop()
                scope.stmt.add(l)
                val ss = scopes.toMutableList()
                ss.add(l)
                stmt(loop.stmt(), ss)
            }

            val exitWhen: ExitwhenContext? = item.exitwhen()
            if (exitWhen != null) {
                val exp = expr(exitWhen.expr(), f)
                if (exp == null) {
                    println("🔥exitwhen no expr")
                } else {
                    scope.stmt.add(JassExitWhen(expr = exp))
                }
            }

            val ctxr: ReturnContext? = item.return_()
            if (ctxr != null) {
                scope.stmt.add(
                    JassReturn(
                        expr = expr(ctxr.expr(), f),
                    )
                )
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

        takes(f, ctx.takes())
        returns(f, ctx.returns_())

        for (vctx: VariableContext in ctx.variable()) {
            val v = JassVar(
                name = vctx.varname().text,
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

        stmt(ctx.stmt(), mutableListOf(f))

        mapNode[f.name] = f
        functions.add(f)
    }

    val errors = mutableListOf<JassError>()

    fun parse(path: String, states: List<JassState> = listOf()) {
        this.states = states

        val cs = CharStreams.fromFileName(path)

        val errorJassErrorListener = JassErrorListener()

        val lexer = JassLexer(cs)
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
}
