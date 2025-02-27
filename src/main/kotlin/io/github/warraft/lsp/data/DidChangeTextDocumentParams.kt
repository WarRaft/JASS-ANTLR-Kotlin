package io.github.warraft.lsp.data

import kotlinx.serialization.Serializable

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#didChangeTextDocumentParams

@Serializable
data class DidChangeTextDocumentParams(
    val textDocument: TextDocumentIdentifier,
    val contentChanges: List<TextDocumentContentChangeEvent>,
)
