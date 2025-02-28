package io.github.warraft.lsp.data

import kotlinx.serialization.Serializable

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#documentSymbol

@Serializable
data class DocumentSymbol(
    val name: String,
    var detail: String? = null,
    val kind: SymbolKind,
    val range: Range,
    val selectionRange: Range,
    var children: MutableList<DocumentSymbol>? = null,
) {
    fun append(child: DocumentSymbol?) {
        if (child == null) return
        children?.add(child) ?: run { children = mutableListOf(child) }
    }

}
