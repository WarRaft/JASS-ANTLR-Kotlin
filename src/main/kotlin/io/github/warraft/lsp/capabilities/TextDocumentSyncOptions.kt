package io.github.warraft.lsp.capabilities

import kotlinx.serialization.Serializable

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#textDocumentSyncOptions

@Serializable
data class TextDocumentSyncOptions(
    val openClose: Boolean?,
    val change: TextDocumentSyncKind?,
)
