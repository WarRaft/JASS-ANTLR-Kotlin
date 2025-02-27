package io.github.warraft.lsp.data

import kotlinx.serialization.Serializable

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#textDocumentIdentifier

@Serializable
data class TextDocumentIdentifier(
    val version: Int? = null,
    val uri: String,
)
