package io.github.warraft.language.jass.lsp.folding

import io.github.warraft.lsp.data.FoldingRange
import io.github.warraft.lsp.data.FoldingRangeKind
import org.antlr.v4.runtime.tree.TerminalNode

class JassFoldingHub {
    val ranges = mutableListOf<FoldingRange>()

    fun add(s: TerminalNode?, e: TerminalNode?) {
        if (s == null || e == null) return
        ranges.add(
            FoldingRange(
                startLine = (s.symbol.line - 1).toUInt(),
                endLine = (e.symbol.line - 1).toUInt(),
                kind = FoldingRangeKind.Region
            )
        )
    }

    fun clear() {
        ranges.clear()
    }
}
