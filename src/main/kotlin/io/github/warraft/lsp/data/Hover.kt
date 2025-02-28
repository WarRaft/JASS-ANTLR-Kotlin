package io.github.warraft.lsp.data

import kotlinx.serialization.Serializable

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#hover

@Serializable
data class Hover(
    val contents: MarkupContent,
    val range: Range? = null,
)
