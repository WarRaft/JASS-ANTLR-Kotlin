package io.github.warraft.language.jass.state.ext.lsp.formatting.formatter.ext

import io.github.warraft.JassParser.ExtendsRuleContext
import io.github.warraft.JassParser.TypeContext
import io.github.warraft.language.jass.state.ext.lsp.formatting.formatter.JassFormatter
import org.antlr.v4.runtime.tree.TerminalNode

fun JassFormatter.type(ctx: TypeContext?) {
    if (ctx == null) return
    tab(ctx, 0)
    val idCtx: TerminalNode? = ctx.ID()

    between(ctx.TYPE(), idCtx, 1)

    val extendsCtx: ExtendsRuleContext = ctx.extendsRule() ?: return
    between(idCtx, extendsCtx, 1)
    between(extendsCtx.EXTENDS(), extendsCtx.ID(), 1)

    trail(ctx)
}
