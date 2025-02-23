package io.github.warraft.jass.antlr.state.ext.lsp4j.formatting.formatter.ext

import io.github.warraft.JassParser.ExtendsRuleContext
import io.github.warraft.JassParser.LINE_COMMENT
import io.github.warraft.JassParser.TypeContext
import io.github.warraft.jass.antlr.state.ext.lsp4j.formatting.formatter.JassFormatter
import org.antlr.v4.runtime.tree.TerminalNode

fun JassFormatter.type(ctx: TypeContext?) {
    if (ctx == null) return
    tab(ctx, 0)
    val idCtx: TerminalNode? = ctx.ID()

    between(ctx.TYPE(), idCtx, " ")

    val extendsCtx: ExtendsRuleContext = ctx.extendsRule() ?: return
    between(idCtx, extendsCtx, " ")
    between(extendsCtx, extendsCtx.ID(), " ")

    val parentCtx = extendsCtx.ID() ?: return
    val next = next(parentCtx) ?: return
    if (next.type != LINE_COMMENT) return
    val cur = parentCtx.symbol
    if (cur.line != next.line) return
    between(cur, next, " ")
}
