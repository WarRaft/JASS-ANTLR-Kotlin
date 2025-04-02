package io.github.warraft.lsp.data

import kotlinx.serialization.Serializable

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#inlayHintParams

@Serializable
data class InlayHintParams(
    val textDocument: TextDocumentIdentifier,
    val range: Range,
)
