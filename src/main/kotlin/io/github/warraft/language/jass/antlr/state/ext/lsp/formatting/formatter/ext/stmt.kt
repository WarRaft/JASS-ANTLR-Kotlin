package io.github.warraft.language.jass.antlr.state.ext.lsp.formatting.formatter.ext

import io.github.warraft.JassParser.ElseRuleContext
import io.github.warraft.JassParser.StmtCallContext
import io.github.warraft.JassParser.StmtContext
import io.github.warraft.JassParser.StmtExitWhenContext
import io.github.warraft.JassParser.StmtIfContext
import io.github.warraft.JassParser.StmtLoopContext
import io.github.warraft.JassParser.StmtReturnContext
import io.github.warraft.JassParser.StmtSetContext
import io.github.warraft.language.jass.antlr.state.ext.lsp.formatting.formatter.JassFormatter
import org.antlr.v4.runtime.ParserRuleContext

fun JassFormatter.stmt(list: List<StmtContext>?, level: Int) {
    if (list == null) return
    for (s in list) stmt(s, level)
}

fun JassFormatter.stmt(ctx: ParserRuleContext?, level: Int) {
    if (ctx == null) return
    tab(ctx, level)
    when (ctx) {
        is StmtLoopContext -> {
            stmt(ctx.stmt(), level + 1)
            tab(ctx.ENDLOOP(), level)
        }

        is StmtIfContext -> {
            tab(ctx.ENDIF(), level)
            stmt(ctx.stmt(), level + 1)
            val ifExprCtx = ctx.expr()
            between(ctx.IF(), ifExprCtx, 1)
            between(ifExprCtx, ctx.THEN(), 1)
            expr(ifExprCtx)

            for (elseIfCtx in ctx.elseif()) {
                tab(elseIfCtx, level)
                stmt(elseIfCtx.stmt(), level + 1)
                val elseIfExprCtx = elseIfCtx.expr()
                between(elseIfCtx.ELSEIF(), elseIfExprCtx, 1)
                between(elseIfExprCtx, elseIfCtx.THEN(), 1)
                expr(elseIfExprCtx)
            }

            val elseCtx: ElseRuleContext? = ctx.elseRule()
            if (elseCtx != null) {
                tab(elseCtx, level)
                stmt(elseCtx.stmt(), level + 1)
            }
        }

        is StmtCallContext -> {
            between(ctx.DEBUG(), ctx.CALL(), 1)
            val idCtx = ctx.ID()
            between(ctx.CALL(), idCtx, 1)
            val lpCtx = ctx.LPAREN()
            between(idCtx, lpCtx, 0)
            paren(ctx.expr(), lpCtx, ctx.RPAREN())
        }

        is StmtSetContext -> {
            val idCtx = ctx.ID()
            between(ctx.SET(), idCtx, 1)
            val eqCtx = ctx.EQ()

            val brackCtx = ctx.setBrack()
            if (brackCtx == null) {
                between(idCtx, eqCtx, 1)
            } else {
                val bExprCtx = brackCtx.expr()

                between(brackCtx.LBRACK(), bExprCtx, 0)
                between(bExprCtx, brackCtx.RBRACK(), 0)

                between(idCtx, brackCtx, 0)
                between(brackCtx, eqCtx, 1)

                expr(bExprCtx)
            }

            val exprCtx = ctx.expr()
            between(eqCtx, exprCtx, 1)
            expr(exprCtx)
        }

        is StmtExitWhenContext -> {
            val exprCtx = ctx.expr()
            between(ctx.EXITWHEN(), exprCtx, 1)
            expr(exprCtx)
        }

        is StmtReturnContext -> {
            val exprCtx = ctx.expr()
            between(ctx.RETURN(), exprCtx, 1)
            expr(exprCtx)
        }

        else -> state.server?.log("stmt: ${ctx.javaClass.simpleName}")
    }
}
