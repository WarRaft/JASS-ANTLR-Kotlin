package io.github.warraft.vex.antlr.state

import io.github.warraft.VjassLexer
import io.github.warraft.VjassParser
import io.github.warraft.VjassParser.*
import io.github.warraft.jass.antlr.utils.JassErrorListener
import io.github.warraft.languages.lsp4j.service.document.semantic.token.SemanticTokenType
import io.github.warraft.languages.antlr.state.LanguageState
import io.github.warraft.languages.antlr.utils.LanguageTokenFactory
import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CommonToken
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.TerminalNode

class VjassState : VexState() {

    override fun parse(stream: CharStream, states: List<LanguageState>, version: Int?) {
        super.parse(stream, states, version)

        val errorJassErrorListener = JassErrorListener()
        val lexer = VjassLexer(stream)
        lexer.removeErrorListeners()
        lexer.addErrorListener(errorJassErrorListener)
        val f = LanguageTokenFactory(mutableMapOf<Int, CommonToken>())
        lexer.tokenFactory = f

        val tokens = CommonTokenStream(lexer)

        val parser = VjassParser(tokens)
        parser.removeErrorListeners()
        parser.addErrorListener(errorJassErrorListener)
        root(parser.root())

        for (c in f.comments) {
            semanticHub.add(c, SemanticTokenType.COMMENT)
        }

    }

    fun root(ctx: RootContext) {
        for (item in ctx.children) {
            when (item) {
                is LibraryContext -> library(item)
                is RootItemContext -> rootItem(item)
            }
        }
    }

    fun library(ctx: LibraryContext) {
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

    fun rootItem(ctx: RootItemContext) {
        for (item in ctx.children) {
            when (item) {
                is GlobalsContext -> globals(item)
                is FunctionContext -> function(item)
                else -> server?.log("💩rootItem: ${item.javaClass.simpleName}")
            }
        }
    }

    fun function(ctx: FunctionContext) {
        semanticHub
            .add(ctx.ID(), SemanticTokenType.FUNCTION)
            .add(ctx.CONSTANT(), SemanticTokenType.KEYWORD)
            .add(ctx.PRIVATE(), SemanticTokenType.KEYWORD)
            .add(ctx.PUBLIC(), SemanticTokenType.KEYWORD)
            .add(ctx.FUNCTION(), SemanticTokenType.KEYWORD)
            .add(ctx.ENDFUNCTION(), SemanticTokenType.KEYWORD)

        val takesCtx: TakesContext? = ctx.takes()
        if (takesCtx != null) {
            semanticHub
                .add(takesCtx.TAKES(), SemanticTokenType.KEYWORD)
                .add(takesCtx.NOTHING(), SemanticTokenType.KEYWORD)

            for (paramCtx in takesCtx.param()) {
                val typenameCtx: TypenameContext? = paramCtx.typename()
                val varnameCtx: VarnameContext? = paramCtx.varname()

                semanticHub
                    .add(typenameCtx?.ID(), SemanticTokenType.TYPE_PARAMETER)
                    .add(varnameCtx?.ID(), SemanticTokenType.PARAMETER)
            }
        }

        val returnsCtx: ReturnsRuleContext? = ctx.returnsRule()
        semanticHub
            .add(returnsCtx?.ID(), SemanticTokenType.TYPE)
            .add(returnsCtx?.RETURNS(), SemanticTokenType.KEYWORD)
            .add(returnsCtx?.NOTHING(), SemanticTokenType.KEYWORD)

        stmt(ctx.stmt())
    }

    fun globals(ctx: GlobalsContext) {
        semanticHub
            .add(ctx.GLOBALS(), SemanticTokenType.KEYWORD)
            .add(ctx.ENDGLOBALS(), SemanticTokenType.KEYWORD)

        stmt(ctx.stmt())
    }

    fun expr(exprsCtx: List<ExprContext>, opsCtx: List<TerminalNode?>) {
        for (exprCtx in exprsCtx) expr(exprCtx)
        for (opCtx in opsCtx) semanticHub.add(opCtx, SemanticTokenType.OPERATOR)
    }

    fun expr(exprCtx: ExprContext?) {
        if (exprCtx == null) return

        when (exprCtx) {
            is ExprEqContext -> expr(exprCtx.expr(), listOf(exprCtx.EQ_EQ(), exprCtx.NEQ()))
            is ExprAddContext -> expr(exprCtx.expr(), listOf(exprCtx.PLUS(), exprCtx.MINUS()))
            is ExprMulContext -> expr(exprCtx.expr(), listOf(exprCtx.MUL(), exprCtx.DIV()))
            is ExprLtContext -> expr(exprCtx.expr(), listOf(exprCtx.LT(), exprCtx.LT_EQ(), exprCtx.GT(), exprCtx.GT_EQ()))
            is ExprAndContext -> expr(exprCtx.expr(), listOf(exprCtx.AND(), exprCtx.OR()))

            is ExprParenContext -> expr(exprCtx.expr())

            is ExprDotContext -> {
                for (it in exprCtx.expr()) expr(it)
            }

            is ExprNullContext -> {
                semanticHub
                    .add(exprCtx.NULL(), SemanticTokenType.KEYWORD)
            }

            is ExprStrContext -> {
                semanticHub
                    .add(exprCtx.STRING(), SemanticTokenType.STRING)
            }

            is ExprBoolContext -> {
                semanticHub
                    .add(exprCtx.TRUE(), SemanticTokenType.KEYWORD)
                    .add(exprCtx.FALSE(), SemanticTokenType.KEYWORD)
            }

            is ExprIntContext -> {
                semanticHub
                    .add(exprCtx.INTVAL(), SemanticTokenType.NUMBER)
                    .add(exprCtx.HEXVAL(), SemanticTokenType.NUMBER)
                    .add(exprCtx.RAWVAL(), SemanticTokenType.NUMBER)
            }

            is ExprRealContext -> {
                semanticHub.add(exprCtx.REALVAL(), SemanticTokenType.NUMBER)
            }

            is ExprCallContext -> {
                semanticHub.add(exprCtx.ID(), SemanticTokenType.VARIABLE)
                for (e in exprCtx.expr()) expr(e)
            }

            is ExprVarContext -> {
                semanticHub
                    .add(exprCtx.ID(), SemanticTokenType.VARIABLE)
            }

            is ExprFunContext -> {
                semanticHub
                    .add(exprCtx.FUNCTION(), SemanticTokenType.KEYWORD)
                    .add(exprCtx.ID(), SemanticTokenType.FUNCTION)
            }

            is ExprUnContext -> {
                semanticHub
                    .add(exprCtx.MINUS(), SemanticTokenType.OPERATOR)
                    .add(exprCtx.NOT(), SemanticTokenType.OPERATOR)

                expr(exprCtx.expr())
            }

            is ExprArrContext -> {
                semanticHub
                    .add(exprCtx.ID(), SemanticTokenType.VARIABLE)

                expr(exprCtx.expr())
            }

            else -> server?.log("💩expr: ${exprCtx.javaClass.simpleName}")
        }
    }

    fun left(leftCtx: LeftContext) {
        when (leftCtx) {
            is LeftCallContext -> {
                left(leftCtx.left())
                for (it in leftCtx.expr()) expr(it)
            }

            is LeftIdContext -> {
                semanticHub
                    .add(leftCtx.ID(), SemanticTokenType.FUNCTION)
            }

            is LeftArrContext -> {
                leftCtx.left().forEach { left(it) }
            }

            else -> server?.log("💩left: ${leftCtx.javaClass.simpleName}")
        }
    }

    fun stmt(stmtsCtx: List<StmtContext>) {
        for (stmtCtx in stmtsCtx) {
            when (stmtCtx) {
                is StmtLeftContext -> {
                    semanticHub
                        .add(stmtCtx.DEBUG(), SemanticTokenType.KEYWORD)
                        .add(stmtCtx.SET(), SemanticTokenType.KEYWORD)
                        .add(stmtCtx.CALL(), SemanticTokenType.KEYWORD)
                        .add(stmtCtx.CONSTANT(), SemanticTokenType.KEYWORD)
                        .add(stmtCtx.EQ(), SemanticTokenType.OPERATOR)

                    left(stmtCtx.left())
                    expr(stmtCtx.expr())
                }

                is StmtVarContext -> {
                    val varnameCtx: VarnameContext? = stmtCtx.varname()
                    val typenameCtx: TypenameContext? = stmtCtx.typename()

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

                is StmtIfContext -> {
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

                    val elseCtx: ElseRuleContext? = stmtCtx.elseRule()
                    if (elseCtx != null) {
                        semanticHub
                            .add(elseCtx.ELSE(), SemanticTokenType.KEYWORD)
                        stmt(elseCtx.stmt())
                    }
                }

                is StmtLoopContext -> {
                    semanticHub
                        .add(stmtCtx.LOOP(), SemanticTokenType.KEYWORD)
                        .add(stmtCtx.ENDLOOP(), SemanticTokenType.KEYWORD)
                    stmt(stmtCtx.stmt())
                }

                is StmtReturnContext -> {
                    semanticHub.add(stmtCtx.RETURN(), SemanticTokenType.VARIABLE)
                    expr(stmtCtx.expr())
                }

                is StmtExitWhenContext -> {
                    semanticHub.add(stmtCtx.EXITWHEN(), SemanticTokenType.KEYWORD)
                    expr(stmtCtx.expr())
                }

                else -> server?.log("💩stmt: ${stmtCtx.javaClass.simpleName}")
            }
        }
    }

}
