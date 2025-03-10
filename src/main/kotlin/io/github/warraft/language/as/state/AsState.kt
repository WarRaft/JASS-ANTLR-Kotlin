package io.github.warraft.language.`as`.state

import io.github.warraft.AsLexer
import io.github.warraft.AsParser
import io.github.warraft.AsParser.*
import io.github.warraft.language._.state.LanguageState
import io.github.warraft.lsp.data.semantic.SemanticTokenType
import io.github.warraft.lsp.data.semantic.SemanticTokenType.*
import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.Lexer
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.tree.TerminalNode
import org.antlr.v4.runtime.tree.TerminalNodeImpl

class AsState : LanguageState() {
    override fun lexer(stream: CharStream): Lexer = AsLexer(stream)
    override fun parser(stream: CommonTokenStream): Parser = AsParser(stream)

    fun root(list: List<RootItemContext>) {
        for (ctx in list) root(ctx)
    }

    fun expr(list: List<ExprContext>, opsCtx: List<TerminalNode?>) {
        expr(list)
        for (opCtx in opsCtx) semanticHub.add(opCtx, OPERATOR)
    }

    fun expr(list: List<ExprContext>) {
        for (ctx in list) expr(ctx)
    }

    fun expr(ctx: ExprContext?) {
        if (ctx == null) return
        when (ctx) {
            is ExprIntContext -> {
                semanticHub
                    .add(ctx.INTVAL(), NUMBER)
                    .add(ctx.HEXVAL(), NUMBER)
                    .add(ctx.RAWVAL(), NUMBER)
            }

            is ExprRealContext -> {
                semanticHub
                    .add(ctx.REALVAL(), NUMBER)
            }

            is ExprVarContext -> {
                semanticHub
                    .add(ctx.ID(), VARIABLE)
            }

            is ExprPreContext -> {
                semanticHub
                    .add(ctx.SUB(), OPERATOR)
                    .add(ctx.NOT(), OPERATOR)
                expr(ctx.expr())
            }

            is ExprStrContext -> {
                semanticHub
                    .add(ctx.STRING(), SemanticTokenType.STRING)
            }

            is ExprPostContext -> {
                semanticHub
                    .add(ctx.ADD_ADD(), SemanticTokenType.STRING)
                expr(ctx.expr())
            }

            is ExprCallContext -> {
                expr(ctx.expr())
            }

            is ExprEqContext -> {
                semanticHub
                    .add(ctx.EQ_EQ(), SemanticTokenType.STRING)
                    .add(ctx.NEQ(), SemanticTokenType.STRING)
                expr(ctx.expr())
            }

            is ExprAddContext -> expr(ctx.expr(), listOf(ctx.ADD(), ctx.SUB()))
            is ExprLtContext -> expr(ctx.expr(), listOf(ctx.LT(), ctx.LT_EQ(), ctx.GT(), ctx.GT_EQ()))

            else -> server?.log("expr: ${ctx.javaClass.simpleName}")
        }
    }

    fun left(ctx: LeftContext) {
        when (ctx) {
            is LeftIdContext -> {
                semanticHub
                    .add(ctx.ID(), VARIABLE)
            }

            is LeftTypeContext -> {
                semanticHub
                    .add(ctx.ID(), TYPE)
                left(ctx.left())
            }

            is LeftCallContext -> {
                left(ctx.left())
                expr(ctx.expr())
            }

            is LeftColContext -> {
                semanticHub
                    .add(ctx.COL_COL(), OPERATOR)
                left(ctx.left())
            }

            else -> server?.log("left: ${ctx.javaClass.simpleName}")
        }
    }

    fun stmt(list: List<StmtContext>) {
        for (ctx in list) stmt(ctx)
    }

    fun stmt(ctx: StmtContext) {
        when (ctx) {
            is StmtLeftContext -> {
                semanticHub
                    .add(ctx.EQ(), OPERATOR)
                    .add(ctx.ADD_EQ(), OPERATOR)
                    .add(ctx.SUB_EQ(), OPERATOR)
                    .add(ctx.MUL_EQ(), OPERATOR)
                    .add(ctx.DIV_EQ(), OPERATOR)

                left(ctx.left())
                expr(ctx.expr())
            }

            is StmtIfContext -> {
                semanticHub
                    .add(ctx.IF(), KEYWORD)
                    .add(ctx.WHILE(), KEYWORD)

                stmt(ctx.stmt())
                expr(ctx.expr())

                val ectx: ElseRuleContext? = ctx.elseRule()
                if (ectx != null) {
                    semanticHub
                        .add(ectx.ELSE(), KEYWORD)
                    stmt(ectx.stmt())
                }
            }

            is StmtReturnContext -> {
                semanticHub
                    .add(ctx.RETURN(), KEYWORD)
                expr(ctx.expr())
            }

            is StmtForContext -> {
                semanticHub
                    .add(ctx.FOR(), KEYWORD)
                stmt(ctx.stmt())
                expr(ctx.expr())
            }

            else -> server?.log("stmt: ${ctx.javaClass.simpleName}")
        }
    }

    fun root(rootCtx: RootItemContext) {
        val ch = rootCtx.children ?: return
        for (ctx in ch) {
            when (ctx) {
                is IncludeContext -> {
                    semanticHub
                        .add(ctx.INCLUDE(), KEYWORD)
                        .add(ctx.STRING(), SemanticTokenType.STRING)
                }

                is NamespaceContext -> {
                    semanticHub
                        .add(ctx.COL_COL(), OPERATOR)
                        .add(ctx.NAMESPACE(), KEYWORD)
                        .add(ctx.ID(), SemanticTokenType.NAMESPACE)

                    root(ctx.rootItem())
                }

                is FuncdefContext -> {
                    semanticHub
                        .add(ctx.ID(), TYPE)
                        .add(ctx.FUNCDEF(), KEYWORD)
                        .add(ctx.varname()?.ID(), FUNCTION)
                }

                is FuncContext -> {
                    semanticHub
                        .add(ctx.typename()?.ID(), TYPE)
                        .add(ctx.varname()?.ID(), FUNCTION)

                    stmt(ctx.stmt())
                }

                is StmtContext -> stmt(ctx)
                else -> server?.log("root: ${ctx.javaClass.simpleName}")
            }
        }
    }

    override fun parse(stream: CharStream, states: List<LanguageState>, version: Int?) {
        if (!needParse(version)) return

        super.parse(stream, states, version)

        rootCtx = (parser as AsParser).root().also {
            it.children.forEach {
                when (it) {
                    is RootItemContext -> root(it)
                    is TerminalNodeImpl -> {}
                    else -> server?.log("parse: ${it.javaClass.simpleName}")
                }
            }
        }

        for (c in tokenFactory.commentList) {
            semanticHub.add(c, SemanticTokenType.COMMENT)
        }
    }
}
