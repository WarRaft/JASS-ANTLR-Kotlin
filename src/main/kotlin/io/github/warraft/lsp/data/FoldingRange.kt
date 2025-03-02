package io.github.warraft.lsp.data

import kotlinx.serialization.Serializable
import org.antlr.v4.runtime.tree.TerminalNode

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#foldingRange

@Serializable
data class FoldingRange(
    val startLine: UInt,
    val startCharacter: UInt? = null,
    val endLine: UInt,
    val endCharacter: UInt? = null,
    var kind: FoldingRangeKind? = null,
    val collapsedText: String? = null,
) {
    companion object {
        fun of(s: TerminalNode?, e: TerminalNode?): FoldingRange? {
            if (s == null || e == null) return null
            return FoldingRange(
                startLine = s.symbol.line.toUInt() - 1u,
                endLine = e.symbol.line.toUInt() - 1u
            )
        }
    }
}
