package io.github.warraft.language.jass.lsp4j.symbol

import io.github.warraft.language._.lsp4j.utils.RangeEx
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.TerminalNode
import org.eclipse.lsp4j.DocumentSymbol
import org.eclipse.lsp4j.SymbolInformation
import org.eclipse.lsp4j.SymbolKind
import org.eclipse.lsp4j.jsonrpc.messages.Either

class JassDocumentSymbolHub {
    val symbols = mutableListOf<Either<SymbolInformation?, DocumentSymbol?>>()

    fun add(
        range: ParserRuleContext?,
        selectionRange: TerminalNode?,
        kind: SymbolKind,
        parent: DocumentSymbol? = null,
    ): DocumentSymbol? {
        if (range == null || selectionRange == null) return null

        val s = DocumentSymbol(
            selectionRange.text,
            kind,
            RangeEx.get(range),
            RangeEx.get(selectionRange),
        )

        if (parent == null) {
            symbols.add(Either.forRight(s))
        } else {
            if (parent.children == null) {
                parent.children = mutableListOf<DocumentSymbol>()
            }
            parent.children.add(s)
        }

        return s
    }

    fun clear() {
        symbols.clear()
    }

}
