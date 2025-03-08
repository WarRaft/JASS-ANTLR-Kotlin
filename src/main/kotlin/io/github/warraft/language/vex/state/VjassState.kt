package io.github.warraft.language.vex.state

import io.github.warraft.VjassLexer
import io.github.warraft.VjassParser
import io.github.warraft.VjassParser.*
import io.github.warraft.ZincParser
import io.github.warraft.language._.state.LanguageState
import io.github.warraft.lsp.data.semantic.SemanticTokenType
import org.antlr.v4.runtime.*
import org.antlr.v4.runtime.tree.TerminalNode

class VjassState : VexState() {
    override fun lexer(stream: CharStream): Lexer = VjassLexer(stream)
    override fun parser(stream: CommonTokenStream): Parser = VjassParser(stream)

    override fun parse(stream: CharStream, states: List<LanguageState>, version: Int?) {
        super.parse(stream, states, version)

        rootCtx = (parser as VjassParser).root().also {
            for (item in it.children) {
                when (item) {
                    is LibraryContext -> library(item)
                    is RootItemContext -> rootItem(item)
                }
            }
        }

        for (c in tokenFactory.commentList) {
            semanticHub.add(c, SemanticTokenType.COMMENT)
        }
    }


    fun library(ctx: LibraryContext) {
        for (idCtx in ctx.ID()) {
            semanticHub.add(idCtx, SemanticTokenType.NAMESPACE)
        }

        semanticHub
            .add(ctx.LIBRARY(), SemanticTokenType.KEYWORD)
            .add(ctx.SCOPE(), SemanticTokenType.KEYWORD)
            .add(ctx.INITIALIZER(), SemanticTokenType.KEYWORD)
            .add(ctx.REQUIRES(), SemanticTokenType.KEYWORD)
            .add(ctx.NEEDS(), SemanticTokenType.KEYWORD)
            .add(ctx.USES(), SemanticTokenType.KEYWORD)
            .add(ctx.ENDLIBRARY(), SemanticTokenType.KEYWORD)
            .add(ctx.ENDSCOPE(), SemanticTokenType.KEYWORD)

        for (item in ctx.rootItem()) rootItem(item)
    }

    fun rootItem(ctx: RootItemContext) {
        for (item in ctx.children) {
            when (item) {
                is GlobalsContext -> globals(item)
                is FunctionContext -> function(item)
                is NativeRuleContext -> function(item)
                else -> server?.log("$path |💩rootItem: ${item.javaClass.simpleName}")
            }
        }
    }

    fun function(ctx: ParserRuleContext?) {
        when (ctx) {
            is FunctionContext -> {
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
        }
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

    fun expr(exprsCtx: List<ExprContext>) {
        for (exprCtx in exprsCtx) expr(exprCtx)
    }

    fun expr(exprCtx: ExprContext?) {
        if (exprCtx == null) return

        when (exprCtx) {
            is ExprEqContext -> expr(exprCtx.expr(), listOf(exprCtx.EQ_EQ(), exprCtx.NEQ()))
            is ExprAddContext -> expr(exprCtx.expr(), listOf(exprCtx.ADD(), exprCtx.SUB()))
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
                    .add(exprCtx.SUB(), SemanticTokenType.OPERATOR)
                    .add(exprCtx.NOT(), SemanticTokenType.OPERATOR)

                expr(exprCtx.expr())
            }

            is ExprArrContext -> {
                semanticHub
                    .add(exprCtx.ID(), SemanticTokenType.VARIABLE)

                expr(exprCtx.expr())
            }

            else -> server?.log("$path |💩expr: ${exprCtx.javaClass.simpleName}")
        }
    }

    fun left(list: List<LeftContext>) = list.forEach { left(it) }
    fun left(ctx: LeftContext) {
        when (ctx) {
            is LeftCallContext -> {
                left(ctx.left())
                expr(ctx.expr())
            }

            is LeftIdContext -> {
                semanticHub
                    .add(ctx.ID(), SemanticTokenType.FUNCTION)
            }

            is LeftArrContext -> {
                expr(ctx.expr())
                left(ctx.left())
            }

            is LeftDotContext -> {
                semanticHub
                    .add(ctx.DOT(), SemanticTokenType.OPERATOR)
            }

            is LeftCommaContext -> {
                semanticHub.add(ctx.COMMA(), SemanticTokenType.VARIABLE)
                left(ctx.left())
            }

            else -> server?.log("💩${path} left: ${ctx.javaClass.simpleName}")
        }
    }

    fun stmt(stmtsCtx: List<StmtContext>) {
        for (ctx in stmtsCtx) stmt(ctx)
    }

    fun stmt(ctx: StmtContext) {
        when (ctx) {
            is StmtLeftContext -> {
                semanticHub
                    .add(ctx.SET(), SemanticTokenType.KEYWORD)
                    .add(ctx.CALL(), SemanticTokenType.KEYWORD)
                    .add(ctx.EQ(), SemanticTokenType.OPERATOR)

                left(ctx.left())
                expr(ctx.expr())
            }

            is StmtVarContext -> {
                val varnameCtx: VarnameContext? = ctx.varname()
                val typenameCtx: TypenameContext? = ctx.typename()

                semanticHub
                    .add(varnameCtx?.ID(), SemanticTokenType.VARIABLE)
                    .add(typenameCtx?.ID(), SemanticTokenType.TYPE)
                    .add(ctx.ARRAY(), SemanticTokenType.KEYWORD)
                    .add(ctx.LOCAL(), SemanticTokenType.KEYWORD)
                    .add(ctx.EQ(), SemanticTokenType.OPERATOR)

                for (brackCtx in ctx.brackExpr()) {
                    expr(brackCtx.expr())
                }

                expr(ctx.expr())
            }

            is StmtIfContext -> {
                semanticHub
                    .add(ctx.IF(), SemanticTokenType.KEYWORD)
                    .add(ctx.THEN(), SemanticTokenType.KEYWORD)
                    .add(ctx.ENDIF(), SemanticTokenType.KEYWORD)

                expr(ctx.expr())
                stmt(ctx.stmt())

                for (elseIfCtx in ctx.elseif()) {
                    semanticHub
                        .add(elseIfCtx.ELSEIF(), SemanticTokenType.KEYWORD)
                        .add(elseIfCtx.THEN(), SemanticTokenType.KEYWORD)
                    expr(elseIfCtx.expr())
                    stmt(elseIfCtx.stmt())
                }

                val elseCtx: ElseRuleContext? = ctx.elseRule()
                if (elseCtx != null) {
                    semanticHub
                        .add(elseCtx.ELSE(), SemanticTokenType.KEYWORD)
                    stmt(elseCtx.stmt())
                }
            }

            is StmtLoopContext -> {
                semanticHub
                    .add(ctx.LOOP(), SemanticTokenType.KEYWORD)
                    .add(ctx.ENDLOOP(), SemanticTokenType.KEYWORD)
                stmt(ctx.stmt())
            }

            is StmtReturnContext -> {
                semanticHub.add(ctx.RETURN(), SemanticTokenType.VARIABLE)
                expr(ctx.expr())
            }

            is StmtExitWhenContext -> {
                semanticHub.add(ctx.EXITWHEN(), SemanticTokenType.KEYWORD)
                expr(ctx.expr())
            }

            is StmtModContext -> {
                semanticHub
                    .add(ctx.DEBUG(), SemanticTokenType.KEYWORD)
                    .add(ctx.STATIC(), SemanticTokenType.KEYWORD)
                    .add(ctx.CONSTANT(), SemanticTokenType.KEYWORD)
                    .add(ctx.PUBLIC(), SemanticTokenType.KEYWORD)
                    .add(ctx.PRIVATE(), SemanticTokenType.KEYWORD)
                stmt(ctx.stmt())
            }

            else -> server?.log("$path |stmt: ${ctx.javaClass.simpleName}")
        }
    }

}
