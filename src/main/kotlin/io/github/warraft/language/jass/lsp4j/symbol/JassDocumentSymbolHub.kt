package io.github.warraft.language.jass.lsp4j.symbol

import io.github.warraft.lsp.data.DocumentSymbol
import io.github.warraft.lsp.data.Range
import io.github.warraft.lsp.data.SymbolKind
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.TerminalNode

class JassDocumentSymbolHub {
    val symbols = mutableListOf<DocumentSymbol>()

    fun add(
        range: ParserRuleContext?,
        selectionRange: TerminalNode?,
        kind: SymbolKind,
        parent: DocumentSymbol? = null,
    ): DocumentSymbol? {
        val name = selectionRange?.text ?: return null

        val r = Range.of(range) ?: return null
        val sr = Range.of(selectionRange) ?: return null

        val s = DocumentSymbol(
            name = name,
            detail = null,
            kind = kind,
            range = r,
            selectionRange = sr,
        )

        if (parent == null) symbols.add(s)
        else parent.append(s)
        return s
    }

    fun clear() {
        symbols.clear()
    }

}

