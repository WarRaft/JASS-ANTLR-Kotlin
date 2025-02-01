package io.github.warraft.jass.lsp4j.folding

import org.antlr.v4.runtime.tree.TerminalNode
import org.eclipse.lsp4j.FoldingRange
import org.eclipse.lsp4j.FoldingRangeKind

class JassFoldingHub {
    val ranges = mutableListOf<FoldingRange>()

    fun add(s: TerminalNode?, e: TerminalNode?) {
        if (s == null || e == null) return

        ranges.add(
            FoldingRange(
                s.symbol.line - 1,
                e.symbol.line - 1,
            ).apply {
                kind = FoldingRangeKind.Region
            })
    }

    fun clear() {
        ranges.clear()
    }
}
