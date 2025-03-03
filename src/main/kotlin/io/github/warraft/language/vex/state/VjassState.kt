package io.github.warraft.language.vex.state

import io.github.warraft.VjassLexer
import io.github.warraft.VjassParser
import io.github.warraft.language._.state.LanguageState
import io.github.warraft.language.vex.state.VexState
import io.github.warraft.lsp.data.semantic.SemanticTokenType
import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.Lexer
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.tree.TerminalNode

class VjassState : VexState() {
    override fun lexer(stream: CharStream): Lexer = VjassLexer(stream)
    override fun parser(stream: CommonTokenStream): Parser = VjassParser(stream)

    override fun parse(stream: CharStream, states: List<LanguageState>, version: Int?) {
        super.parse(stream, states, version)

        rootCtx = (parser as VjassParser).root().also {
            for (item in it.children) {
                when (item) {
                    is VjassParser.LibraryContext -> library(item)
                    is VjassParser.RootItemContext -> rootItem(item)
                }
            }
        }

        for (c in tokenFactory.commentList) {
            semanticHub.add(c, SemanticTokenType.COMMENT)
        }
    }


    fun library(ctx: VjassParser.LibraryContext) {
        for (idCtx in ctx.ID()) {
            semanticHub.add(idCtx, SemanticTokenType.NAMESPACE)
        }

        semanticHub
            .add(ctx.LIBRARY(), SemanticTokenType.KEYWORD)
            .add(ctx.INITIALIZER(), SemanticTokenType.KEYWORD)
            .add(ctx.REQUIRES(), SemanticTokenType.KEYWORD)
            .add(ctx.NEEDS(), SemanticTokenType.KEYWORD)
            .add(ctx.USES(), SemanticTokenType.KEYWORD)
            .add(ctx.ENDLIBRARY(), SemanticTokenType.KEYWORD)

        for (item in ctx.rootItem()) rootItem(item)
    }

    fun rootItem(ctx: VjassParser.RootItemContext) {
        for (item in ctx.children) {
            when (item) {
                is VjassParser.GlobalsContext -> globals(item)
                is VjassParser.FunctionContext -> function(item)
                else -> server?.log("💩rootItem: ${item.javaClass.simpleName}")
            }
        }
    }

    fun function(ctx: VjassParser.FunctionContext) {
        semanticHub
            .add(ctx.ID(), SemanticTokenType.FUNCTION)
            .add(ctx.CONSTANT(), SemanticTokenType.KEYWORD)
            .add(ctx.PRIVATE(), SemanticTokenType.KEYWORD)
            .add(ctx.PUBLIC(), SemanticTokenType.KEYWORD)
            .add(ctx.FUNCTION(), SemanticTokenType.KEYWORD)
            .add(ctx.ENDFUNCTION(), SemanticTokenType.KEYWORD)

        val takesCtx: VjassParser.TakesContext? = ctx.takes()
        if (takesCtx != null) {
            semanticHub
                .add(takesCtx.TAKES(), SemanticTokenType.KEYWORD)
                .add(takesCtx.NOTHING(), SemanticTokenType.KEYWORD)

            for (paramCtx in takesCtx.param()) {
                val typenameCtx: VjassParser.TypenameContext? = paramCtx.typename()
                val varnameCtx: VjassParser.VarnameContext? = paramCtx.varname()

                semanticHub
                    .add(typenameCtx?.ID(), SemanticTokenType.TYPE_PARAMETER)
                    .add(varnameCtx?.ID(), SemanticTokenType.PARAMETER)
            }
        }

        val returnsCtx: VjassParser.ReturnsRuleContext? = ctx.returnsRule()
        semanticHub
            .add(returnsCtx?.ID(), SemanticTokenType.TYPE)
            .add(returnsCtx?.RETURNS(), SemanticTokenType.KEYWORD)
            .add(returnsCtx?.NOTHING(), SemanticTokenType.KEYWORD)

        stmt(ctx.stmt())
    }

    fun globals(ctx: VjassParser.GlobalsContext) {
        semanticHub
            .add(ctx.GLOBALS(), SemanticTokenType.KEYWORD)
            .add(ctx.ENDGLOBALS(), SemanticTokenType.KEYWORD)

        stmt(ctx.stmt())
    }

    fun expr(exprsCtx: List<VjassParser.ExprContext>, opsCtx: List<TerminalNode?>) {
        for (exprCtx in exprsCtx) expr(exprCtx)
        for (opCtx in opsCtx) semanticHub.add(opCtx, SemanticTokenType.OPERATOR)
    }

    fun expr(exprCtx: VjassParser.ExprContext?) {
        if (exprCtx == null) return

        when (exprCtx) {
            is VjassParser.ExprEqContext -> expr(exprCtx.expr(), listOf(exprCtx.EQ_EQ(), exprCtx.NEQ()))
            is VjassParser.ExprAddContext -> expr(exprCtx.expr(), listOf(exprCtx.PLUS(), exprCtx.MINUS()))
            is VjassParser.ExprMulContext -> expr(exprCtx.expr(), listOf(exprCtx.MUL(), exprCtx.DIV()))
            is VjassParser.ExprLtContext -> expr(exprCtx.expr(), listOf(exprCtx.LT(), exprCtx.LT_EQ(), exprCtx.GT(), exprCtx.GT_EQ()))
            is VjassParser.ExprAndContext -> expr(exprCtx.expr(), listOf(exprCtx.AND(), exprCtx.OR()))

            is VjassParser.ExprParenContext -> expr(exprCtx.expr())

            is VjassParser.ExprDotContext -> {
                for (it in exprCtx.expr()) expr(it)
            }

            is VjassParser.ExprNullContext -> {
                semanticHub
                    .add(exprCtx.NULL(), SemanticTokenType.KEYWORD)
            }

            is VjassParser.ExprStrContext -> {
                semanticHub
                    .add(exprCtx.STRING(), SemanticTokenType.STRING)
            }

            is VjassParser.ExprBoolContext -> {
                semanticHub
                    .add(exprCtx.TRUE(), SemanticTokenType.KEYWORD)
                    .add(exprCtx.FALSE(), SemanticTokenType.KEYWORD)
            }

            is VjassParser.ExprIntContext -> {
                semanticHub
                    .add(exprCtx.INTVAL(), SemanticTokenType.NUMBER)
                    .add(exprCtx.HEXVAL(), SemanticTokenType.NUMBER)
                    .add(exprCtx.RAWVAL(), SemanticTokenType.NUMBER)
            }

            is VjassParser.ExprRealContext -> {
                semanticHub.add(exprCtx.REALVAL(), SemanticTokenType.NUMBER)
            }

            is VjassParser.ExprCallContext -> {
                semanticHub.add(exprCtx.ID(), SemanticTokenType.VARIABLE)
                for (e in exprCtx.expr()) expr(e)
            }

            is VjassParser.ExprVarContext -> {
                semanticHub
                    .add(exprCtx.ID(), SemanticTokenType.VARIABLE)
            }

            is VjassParser.ExprFunContext -> {
                semanticHub
                    .add(exprCtx.FUNCTION(), SemanticTokenType.KEYWORD)
                    .add(exprCtx.ID(), SemanticTokenType.FUNCTION)
            }

            is VjassParser.ExprUnContext -> {
                semanticHub
                    .add(exprCtx.MINUS(), SemanticTokenType.OPERATOR)
                    .add(exprCtx.NOT(), SemanticTokenType.OPERATOR)

                expr(exprCtx.expr())
            }

            is VjassParser.ExprArrContext -> {
                semanticHub
                    .add(exprCtx.ID(), SemanticTokenType.VARIABLE)

                expr(exprCtx.expr())
            }

            else -> server?.log("💩expr: ${exprCtx.javaClass.simpleName}")
        }
    }

    fun left(leftCtx: VjassParser.LeftContext) {
        when (leftCtx) {
            is VjassParser.LeftCallContext -> {
                left(leftCtx.left())
                for (it in leftCtx.expr()) expr(it)
            }

            is VjassParser.LeftIdContext -> {
                semanticHub
                    .add(leftCtx.ID(), SemanticTokenType.FUNCTION)
            }

            is VjassParser.LeftArrContext -> {
                leftCtx.left().forEach { left(it) }
            }

            else -> server?.log("💩left: ${leftCtx.javaClass.simpleName}")
        }
    }

    fun stmt(stmtsCtx: List<VjassParser.StmtContext>) {
        for (stmtCtx in stmtsCtx) {
            when (stmtCtx) {
                is VjassParser.StmtLeftContext -> {
                    semanticHub
                        .add(stmtCtx.DEBUG(), SemanticTokenType.KEYWORD)
                        .add(stmtCtx.SET(), SemanticTokenType.KEYWORD)
                        .add(stmtCtx.CALL(), SemanticTokenType.KEYWORD)
                        .add(stmtCtx.CONSTANT(), SemanticTokenType.KEYWORD)
                        .add(stmtCtx.EQ(), SemanticTokenType.OPERATOR)

                    left(stmtCtx.left())
                    expr(stmtCtx.expr())
                }

                is VjassParser.StmtVarContext -> {
                    val varnameCtx: VjassParser.VarnameContext? = stmtCtx.varname()
                    val typenameCtx: VjassParser.TypenameContext? = stmtCtx.typename()

                    semanticHub
                        .add(varnameCtx?.ID(), SemanticTokenType.VARIABLE)
                        .add(typenameCtx?.ID(), SemanticTokenType.TYPE)
                        .add(stmtCtx.CONSTANT(), SemanticTokenType.KEYWORD)
                        .add(stmtCtx.PRIVATE(), SemanticTokenType.KEYWORD)
                        .add(stmtCtx.ARRAY(), SemanticTokenType.KEYWORD)
                        .add(stmtCtx.PUBLIC(), SemanticTokenType.KEYWORD)
                        .add(stmtCtx.LOCAL(), SemanticTokenType.KEYWORD)
                        .add(stmtCtx.EQ(), SemanticTokenType.OPERATOR)

                    for (brackCtx in stmtCtx.brackExpr()) {
                        expr(brackCtx.expr())
                    }

                    expr(stmtCtx.expr())
                }

                is VjassParser.StmtIfContext -> {
                    semanticHub
                        .add(stmtCtx.IF(), SemanticTokenType.KEYWORD)
                        .add(stmtCtx.STATIC(), SemanticTokenType.KEYWORD)
                        .add(stmtCtx.THEN(), SemanticTokenType.KEYWORD)
                        .add(stmtCtx.ENDIF(), SemanticTokenType.KEYWORD)

                    expr(stmtCtx.expr())
                    stmt(stmtCtx.stmt())

                    for (elseIfCtx in stmtCtx.elseif()) {
                        semanticHub
                            .add(elseIfCtx.ELSEIF(), SemanticTokenType.KEYWORD)
                            .add(elseIfCtx.THEN(), SemanticTokenType.KEYWORD)
                        expr(elseIfCtx.expr())
                        stmt(elseIfCtx.stmt())
                    }

                    val elseCtx: VjassParser.ElseRuleContext? = stmtCtx.elseRule()
                    if (elseCtx != null) {
                        semanticHub
                            .add(elseCtx.ELSE(), SemanticTokenType.KEYWORD)
                        stmt(elseCtx.stmt())
                    }
                }

                is VjassParser.StmtLoopContext -> {
                    semanticHub
                        .add(stmtCtx.LOOP(), SemanticTokenType.KEYWORD)
                        .add(stmtCtx.ENDLOOP(), SemanticTokenType.KEYWORD)
                    stmt(stmtCtx.stmt())
                }

                is VjassParser.StmtReturnContext -> {
                    semanticHub.add(stmtCtx.RETURN(), SemanticTokenType.VARIABLE)
                    expr(stmtCtx.expr())
                }

                is VjassParser.StmtExitWhenContext -> {
                    semanticHub.add(stmtCtx.EXITWHEN(), SemanticTokenType.KEYWORD)
                    expr(stmtCtx.expr())
                }

                else -> server?.log("💩stmt: ${stmtCtx.javaClass.simpleName}")
            }
        }
    }

}
