package io.github.warraft.jass.antlr.state.ext.lsp4j.formatting.formatter.ext

import io.github.warraft.JassParser.*
import io.github.warraft.jass.antlr.state.ext.lsp4j.formatting.formatter.JassFormatter
import org.antlr.v4.runtime.tree.TerminalNode

fun JassFormatter.expr(ctx: ExprContext?) {
    if (ctx == null) return

    fun around(sList: List<TerminalNode?>, eList: List<ExprContext>?) {
        if (eList?.size != 2) return
        val a = eList[0]
        val b = eList[1]

        for (ctx in sList) {
            if (ctx == null) continue
            between(a, ctx, 1)
            between(ctx, b, 1)
        }
        expr(a)
        expr(b)
    }

    when (ctx) {
        is ExprCallContext -> paren(ctx.expr(), ctx.LPAREN(), ctx.RPAREN())
        is ExprArrContext -> {
            val lbCtx = ctx.LBRACK()
            between(ctx.ID(), lbCtx, 0)
            val bExprCtx = ctx.expr()
            if (bExprCtx == null) {
                between(lbCtx, ctx.RBRACK(), 0)
            } else {
                between(lbCtx, bExprCtx, 0)
                between(bExprCtx, ctx.RBRACK(), 0)
            }
            expr(bExprCtx)
        }

        is ExprParenContext -> {
            val exprCtx = ctx.expr()
            between(ctx.LPAREN(), exprCtx, 0)
            between(exprCtx, ctx.RPAREN(), 0)
            expr(exprCtx)
        }

        is ExprUnContext -> {
            val exprCtx = ctx.expr()

            ctx.MINUS()?.let {
                between(it, exprCtx, 0)
            }
            ctx.NOT()?.let {
                between(it, exprCtx, 1)
            }

            expr(exprCtx)
        }

        is ExprFunContext -> {
            between(ctx.FUNCTION(), ctx.ID(), 1)
        }

        is ExprAddContext -> around(listOf(ctx.PLUS(), ctx.MINUS()), ctx.expr())
        is ExprMulContext -> around(listOf(ctx.MUL(), ctx.DIV()), ctx.expr())
        is ExprLtContext -> around(listOf(ctx.LT(), ctx.LT_EQ(), ctx.GT(), ctx.GT_EQ()), ctx.expr())
        is ExprEqContext -> around(listOf(ctx.EQ_EQ(), ctx.NEQ()), ctx.expr())
        is ExprAndContext -> around(listOf(ctx.AND(), ctx.OR()), ctx.expr())

        is ExprBoolContext,
        is ExprIntContext,
        is ExprRealContext,
        is ExprStrContext,
        is ExprNullContext,
        is ExprVarContext,
            -> null

        else -> state.server?.log("🔥expr: ${ctx.javaClass.simpleName}")
    }
}
