package raft.war.antlr.jass

import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.ParserRuleContext
import raft.war.antlr.grammar.Jass.JassBaseVisitor
import raft.war.antlr.grammar.Jass.JassLexer
import raft.war.antlr.grammar.Jass.JassParser
import raft.war.antlr.grammar.Jass.JassParser.*
import raft.war.antlr.jass.error.JassError
import raft.war.antlr.jass.error.JassErrorId
import raft.war.antlr.jass.error.JassErrorListener
import raft.war.antlr.jass.psi.IJassNode
import raft.war.antlr.jass.psi.IJassType
import raft.war.antlr.jass.psi.JassBool
import raft.war.antlr.jass.psi.JassBoolType
import raft.war.antlr.jass.psi.JassCodeType
import raft.war.antlr.jass.psi.JassExpr
import raft.war.antlr.jass.psi.JassExprOp
import raft.war.antlr.jass.psi.JassFun
import raft.war.antlr.jass.psi.JassHandleType
import raft.war.antlr.jass.psi.JassInt
import raft.war.antlr.jass.psi.JassIntType
import raft.war.antlr.jass.psi.JassReal
import raft.war.antlr.jass.psi.JassRealType
import raft.war.antlr.jass.psi.JassStr
import raft.war.antlr.jass.psi.JassStrType
import raft.war.antlr.jass.psi.JassUndefined
import raft.war.antlr.jass.psi.JassUndefinedType
import raft.war.antlr.jass.psi.JassVar

class JassState : JassBaseVisitor<IJassNode>() {
    var states: List<JassState> = listOf()

    val natives: MutableList<JassFun> = mutableListOf()
    val globals: MutableList<JassVar> = mutableListOf()
    val functions: MutableList<JassFun> = mutableListOf()

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

        if (ctx.EQ() != null) {
            v.expr = visit(ctx.expr()) as JassExpr?
            if (v.expr == null) return printctx(ctx)

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

        if (getNode(f.name) != null) {
            errors.add(JassError(JassErrorId.REDECLARED, ctx.start.line, 0, "${f.name} redeclared"))
            return
        }

        takes(f, ctx.takes())
        returns(f, ctx.returns_())

        mapNode[f.name] = f
        natives.add(f)
    }

    fun function(ctx: FunctionContext) {
        val f = JassFun(
            name = ctx.ID().text,
        )

        if (getNode(f.name) != null) {
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
                v.expr = visit(vctx.expr()) as JassExpr?
                if (v.expr == null) return printctx(ctx)
            }

            f.param.add(v)
        }

        for (stmt: StmtContext in ctx.stmt()) {


            val loop = stmt.loop()

            println("${stmt.javaClass}")
        }

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
            f.arg.add(visit(it) as JassExpr)
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
