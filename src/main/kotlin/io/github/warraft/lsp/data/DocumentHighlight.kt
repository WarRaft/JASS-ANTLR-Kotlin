package io.github.warraft.lsp.data

import kotlinx.serialization.Serializable

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#documentHighlight

@Serializable
data class DocumentHighlight(
    val range: Range,
    val kind: DocumentHighlightKind? = null,
)
