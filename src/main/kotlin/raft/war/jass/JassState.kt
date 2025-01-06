package raft.war.jass

import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.TerminalNode
import raft.war.grammar.Jass.JassBaseVisitor
import raft.war.grammar.Jass.JassLexer
import raft.war.grammar.Jass.JassParser
import raft.war.grammar.Jass.JassParser.*
import raft.war.jass.error.JassError
import raft.war.jass.error.JassErrorId
import raft.war.jass.error.JassErrorListener
import raft.war.jass.psi.*
import raft.war.jass.psi.IJassNode
import raft.war.jass.psi.IJassType
import raft.war.jass.psi.JassUndefinedType

class JassState : JassBaseVisitor<IJassNode>() {
    var states: List<JassState> = listOf()

    val natives: MutableList<JassFun> = mutableListOf()
    val globals: MutableList<JassVar> = mutableListOf()

    val mapNode: MutableMap<String, IJassNode> = mutableMapOf()
    fun getNode(key: String): IJassNode? {
        var node: IJassNode? = null
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

    private fun printctx(ctx: ParserRuleContext) {
        return
        print("💋")
        for (i in 0..ctx.childCount - 1) {
            print(ctx.getChild(i).text)
            print(" ")
        }
        print("\n")
    }

    private fun global(ctx: VariableContext) {
        val v = JassVar(
            name = ctx.varname().text,
            constant = ctx.CONSTANT() != null,
            array = ctx.ARRAY() != null,
            global = true,
            type = typeFromString(ctx.typename().text)
        )

        val expr = ctx.expr()
        if (expr != null) {
            if (ctx.EQ() != null) {
                v.expr = visit(expr) as JassExpr?
                if (v.expr == null) return printctx(ctx)
            }

            val ta: IJassType = v.type
            val tb: IJassType = v.expr!!.type
            val t = ta.op(JassExprOp.Set, tb)
            if (t is JassUndefinedType) {
                errors.add(JassError(JassErrorId.TYPE_CAST, ctx.start.line, 0, "$ta ${JassExprOp.Set} $tb is $t"))
            }
        }

        if (getNode(v.name) != null) {
            errors.add(JassError(JassErrorId.REDECLARED, ctx.start.line, 0, v.name))
            return
        }

        mapNode[v.name] = v
        globals.add(v)
    }

    fun takes(f: JassFun, ctx: TakesContext) {
        if (ctx.NOTHING() != null) return

        ctx.params().param().forEach {
            f.params.add(
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

        if (getNode(f.name) != null) {
            errors.add(JassError(JassErrorId.REDECLARED, ctx.start.line, 0, "${f.name} redeclared"))
            return
        }

        takes(f, ctx.takes())
        returns(f, ctx.returns_())

        mapNode[f.name] = f
        natives.add(f)
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
                is TerminalNode -> null
                else -> {
                    printctx(it as ParserRuleContext)
                    //println("noparse: $it")
                }
            }
        }

        return null
    }


    override fun visitExprVar(ctx: ExprVarContext): JassExpr {
        val name = ctx.text
        var node: IJassNode? = getNode(name)

        if (node !is JassVar) {
            println("$name undefined")
        }
        return JassExpr(op = JassExprOp.Get, a = node ?: JassUndefined(name))
    }

    override fun visitExprAdd(ctx: ExprAddContext): IJassNode = JassExpr(
        op = if (ctx.PLUS() != null) JassExprOp.Add else JassExprOp.Sub,
        a = visit(ctx.expr(0)) as JassExpr,
        b = visit(ctx.expr(1)) as JassExpr
    )

    override fun visitExprMul(ctx: ExprMulContext): IJassNode = JassExpr(
        op = if (ctx.MUL() != null) JassExprOp.Mul else JassExprOp.Div,
        a = visit(ctx.expr(0)) as JassExpr,
        b = visit(ctx.expr(1)) as JassExpr
    )

    override fun visitExprCall(ctx: ExprCallContext): IJassNode {
        val name = ctx.ID().text
        val f = JassFun(
            name = name,
        )

        val node = getNode(name)
        if (node is JassFun) {
            f.type = node.type
        }

        ctx.expr().forEach {
            f.args.add(visit(it) as JassExpr)
        }

        return JassExpr(
            op = JassExprOp.Get,
            a = f
        )
    }

    override fun visitExprInt(ctx: ExprIntContext): IJassNode = JassExpr(op = JassExprOp.Get, a = JassInt(ctx.text))
    override fun visitExprReal(ctx: ExprRealContext): IJassNode = JassExpr(op = JassExprOp.Get, a = JassReal(ctx.text))
    override fun visitExprStr(ctx: ExprStrContext): IJassNode = JassExpr(op = JassExprOp.Get, a = JassStr(ctx.text))
    override fun visitExprBool(ctx: ExprBoolContext): IJassNode = JassExpr(op = JassExprOp.Get, a = JassBool(ctx.text))
}
