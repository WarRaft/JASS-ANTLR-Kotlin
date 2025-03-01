package io.github.warraft.lsp.data

import kotlinx.serialization.Serializable

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#textEdit

@Serializable
data class TextEdit(
    val range: Range,
    val newText: String,
)
