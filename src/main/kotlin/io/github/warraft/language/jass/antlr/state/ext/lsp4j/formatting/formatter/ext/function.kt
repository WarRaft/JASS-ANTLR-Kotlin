package io.github.warraft.language.jass.antlr.state.ext.lsp4j.formatting.formatter.ext

import io.github.warraft.JassParser.*
import io.github.warraft.language.jass.antlr.state.ext.lsp4j.formatting.formatter.JassFormatter
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.TerminalNode

fun JassFormatter.function(ctx: ParserRuleContext?) {
    tab(ctx, 0)

    var nativeCtx: TerminalNode? = null
    var idCtx: TerminalNode? = null
    var takesCtx: TakesContext? = null
    var returnsCtx: ReturnsRuleContext? = null

    when (ctx) {
        is NativeRuleContext -> {
            nativeCtx = ctx.NATIVE()
            idCtx = ctx.ID()
            takesCtx = ctx.takes()
            returnsCtx = ctx.returnsRule()

            between(ctx.CONSTANT(), nativeCtx, 1)
        }

        is FunctionContext -> {
            nativeCtx = ctx.FUNCTION()
            idCtx = ctx.ID()
            takesCtx = ctx.takes()
            between(ctx.CONSTANT(), nativeCtx, 1)
            returnsCtx = ctx.returnsRule()

            tab(ctx.ENDFUNCTION(), 0)

            variable(ctx.variable())
            stmt(ctx.stmt(), 1)
        }
    }

    between(nativeCtx, idCtx, 1)
    between(idCtx, takesCtx, 1)

    between(takesCtx?.TAKES(), takesCtx?.NOTHING(), 1)

    if (takesCtx != null) for (pCtx in takesCtx.param()) {
        val prev = prev(pCtx)
        when (prev?.type) {
            COMMA,
            TAKES,
                -> between(prev, pCtx, 1)
        }
        between(pCtx.typename(), pCtx.varname(), 1)
        val next = next(pCtx)
        if (next?.type == COMMA) between(pCtx, next, 0)

    }

    between(takesCtx, returnsCtx, 1)
    val rCtx = returnsCtx?.RETURNS()
    between(rCtx, returnsCtx?.NOTHING(), 1)
    between(rCtx, returnsCtx?.ID(), 1)
}
