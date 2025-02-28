package io.github.warraft.lsp.data
import kotlinx.serialization.Serializable
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.Token
import org.antlr.v4.runtime.tree.TerminalNode

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#range

@Serializable
data class Range(
    val start: Position,
    val end: Position,
) {
    companion object {
        private fun get(start: Token?, stop: Token?): Range? {
            if (start == null || stop == null) return null
            return Range(
                Position(
                    (start.line - 1).toUInt(),
                    start.charPositionInLine.toUInt()
                ),
                Position(
                    (stop.line - 1).toUInt(),
                    (stop.charPositionInLine + (stop.stopIndex - stop.startIndex) + 1).toUInt(),
                )
            )
        }

        fun of(token: Token?): Range? = get(token, token)
        fun of(ctx: ParserRuleContext?): Range? = get(ctx?.start, ctx?.stop)
        fun of(node: TerminalNode?): Range? = get(node?.symbol, node?.symbol)
    }
}
