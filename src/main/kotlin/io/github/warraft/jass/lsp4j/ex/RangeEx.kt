package io.github.warraft.jass.lsp4j.ex

import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.Token
import org.antlr.v4.runtime.tree.TerminalNode
import org.eclipse.lsp4j.Position
import org.eclipse.lsp4j.Range

class RangeEx : Range() {

    companion object {
        private fun toRange(start: Token, stop: Token): Range {
            return Range(
                Position(start.line - 1, start.charPositionInLine),
                Position(
                    stop.line - 1,
                    stop.charPositionInLine + (stop.stopIndex - stop.startIndex) + 1
                )
            )
        }

        fun get(ctx: ParserRuleContext?): Range = if (ctx == null) Range(
            Position(0, 0),
            Position(0, 0),
        ) else
            toRange(ctx.start, ctx.stop)

        fun get(node: TerminalNode?): Range = if (node == null) Range(
            Position(0, 0),
            Position(0, 0),
        ) else
            toRange(node.symbol, node.symbol)
    }
}
