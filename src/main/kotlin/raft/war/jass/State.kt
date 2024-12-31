package raft.war.jass

import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import raft.war.grammar.Jass.JassBaseVisitor
import raft.war.grammar.Jass.JassLexer
import raft.war.grammar.Jass.JassParser
import raft.war.grammar.Jass.JassParser.*
import raft.war.jass.checker.error.Error
import raft.war.jass.checker.error.Listener
import raft.war.jass.psi.*
import raft.war.jass.psi.type.Type

class State : JassBaseVisitor<Node>() {
    val map: MutableMap<Int, Node> = mutableMapOf()

    val globals: MutableList<Variable> = mutableListOf()

    fun typeFromString(str: String): Type? = when (str) {
        "integer" -> raft.war.jass.psi.type.Integer()
        "real" -> raft.war.jass.psi.type.Real()
        "string" -> raft.war.jass.psi.type.Str()
        else -> {
            println("🔥 Unrecognized string: $str")
            null
        }
    }

    fun global(ctx: VariableContext) {
        val v = Variable(
            name = ctx.varname().text,
            constant = ctx.CONSTANT() != null,
            array = ctx.ARRAY() != null,
            global = true,
            type = typeFromString(ctx.typename().text)
        )

        val expr = ctx.expr()
        if (expr != null) {
            v.expr = visit(expr) as Expr?
            //type = v.expr!!.type(this)
        }

        print("💋$v ::   \n💩")
        for (i in 0..ctx.childCount - 1) {
            print(ctx.getChild(i).text)
            print(" ")
        }
        print("\n")
    }

    val errors = mutableListOf<Error>()

    fun parse(path: String) {
        val cs = CharStreams.fromFileName(path)

        val errorListener = Listener()

        val lexer = JassLexer(cs)
        lexer.removeErrorListeners()
        lexer.addErrorListener(errorListener)

        val tokens = CommonTokenStream(lexer)

        val parser = JassParser(tokens)
        parser.removeErrorListeners()
        parser.addErrorListener(errorListener)
        parser.root().accept(this)

        if (errorListener.errors.isNotEmpty()) {
            errors.addAll(errorListener.errors)
        }
    }

    override fun visitRoot(ctx: RootContext): Node? {
        ctx.children.forEach {
            when (it) {
                is GlobalsContext -> it.variable().forEach(::global)

                else -> {
                    println("noparse: $it")
                }
            }
        }

        return null
    }

    override fun visitExprAdd(ctx: ExprAddContext): Node = Expr(
        op = if (ctx.PLUS() != null) Op.Add else Op.Sub,
        a = visit(ctx.expr(0)) as Expr,
        b = visit(ctx.expr(1)) as Expr
    )


    override fun visitExprMul(ctx: ExprMulContext): Node = Expr(
        op = if (ctx.MUL() != null) Op.Mul else Op.Div,
        a = visit(ctx.expr(0)) as Expr,
        b = visit(ctx.expr(1)) as Expr
    )

    override fun visitExprInt(ctx: ExprIntContext): Node = Expr(op = Op.Get, a = Integer(ctx.text))
    override fun visitExprReal(ctx: ExprRealContext): Node = Expr(op = Op.Get, a = Real(ctx.text))
    override fun visitExprStr(ctx: ExprStrContext): Node? = Expr(op = Op.Get, a = Str(ctx.text))

    override fun visitExprPrim(ctx: ExprPrimContext?): Node? {
        println("⚠️ primExpr: ${ctx?.text}")
        return null
    }

    override fun visitPrim(ctx: PrimContext?): Node? {
        println("⚠️ prim: ${ctx?.text}")
        return null
    }

}
