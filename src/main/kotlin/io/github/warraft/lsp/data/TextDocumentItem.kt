package io.github.warraft.lsp.data

import kotlinx.serialization.Serializable

@Serializable
data class TextDocumentItem(
    val uri: String,
    val languageId: String,
    val version: Int,
    val text: String,
)
