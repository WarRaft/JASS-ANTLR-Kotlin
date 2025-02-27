package io.github.warraft.language.jass.antlr.state.ext.lsp4j.formatting.formatter.ext

import io.github.warraft.JassParser.VariableContext
import io.github.warraft.language.jass.antlr.state.ext.lsp4j.formatting.formatter.JassFormatter


fun JassFormatter.variable(list: List<VariableContext>?) {
    if (list.isNullOrEmpty()) return
    for (ctx in list) variable(ctx)
}

fun JassFormatter.variable(ctx: VariableContext?) {
    if (ctx == null) return
    tab(ctx, 1)

    val typeCtx = ctx.typename()
    val nameCtx = ctx.varname()
    val eqCtx = ctx.EQ()
    val exprCtx = ctx.expr()
    val arrayCtx = ctx.ARRAY()

    between(ctx.LOCAL(), typeCtx, 1)

    if (arrayCtx == null) {
        between(typeCtx, nameCtx, 1)
        between(nameCtx, eqCtx, 1)
    } else {
        between(typeCtx, arrayCtx, 1)
        between(arrayCtx, nameCtx, 1)
    }

    between(ctx.CONSTANT(), typeCtx, 1)
    between(eqCtx, exprCtx, 1)

    trail(ctx)

    expr(exprCtx)
}
