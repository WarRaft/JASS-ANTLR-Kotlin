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
    val mapId: MutableMap<String, IJassNode> = mutableMapOf()

    val globals: MutableList<JassVar> = mutableListOf()

    val mapType: MutableMap<String, JassHandleType> = mutableMapOf()
    val types: MutableList<JassHandleType> = mutableListOf()

    fun typeFromString(str: String): IJassType = when (str) {
        "integer" -> JassIntType()
        "real" -> JassRealType()
        "string" -> JassStrType()
        "boolean" -> JassBoolType()
        "handle" -> JassHandleType(str)
        else -> mapType[str] ?: JassUndefinedType()
    }

    private fun handle(ctx: TypeContext) {
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
            v.expr = visit(expr) as JassExpr?
            if (v.expr == null) return printctx(ctx)

            val ta: IJassType = v.type
            val tb: IJassType = v.expr!!.type
            val t = ta.op(JassExprOp.Set, tb)
            if (t is JassUndefinedType) {
                errors.add(JassError(JassErrorId.TYPE_CAST, ctx.start.line, 0, "$ta ${JassExprOp.Set} $tb is $t"))
            }
        }

        if (mapId.containsKey(v.name)) {
            errors.add(JassError(JassErrorId.REDECLARED, ctx.start.line, 0, v.name))
            return
        }

        mapId[v.name] = v
        globals.add(v)
    }

    val errors = mutableListOf<JassError>()

    fun parse(path: String) {
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
                is TypeContext -> handle(it)

                is TerminalNode -> println("\n✅\n")
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
        var node: IJassNode? = null

        if (mapId.containsKey(name)) {
            node = mapId[name]
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

    override fun visitExprInt(ctx: ExprIntContext): IJassNode = JassExpr(op = JassExprOp.Get, a = JassInt(ctx.text))
    override fun visitExprReal(ctx: ExprRealContext): IJassNode = JassExpr(op = JassExprOp.Get, a = JassReal(ctx.text))
    override fun visitExprStr(ctx: ExprStrContext): IJassNode = JassExpr(op = JassExprOp.Get, a = JassStr(ctx.text))
    override fun visitExprBool(ctx: ExprBoolContext): IJassNode = JassExpr(op = JassExprOp.Get, a = JassBool(ctx.text))
}
