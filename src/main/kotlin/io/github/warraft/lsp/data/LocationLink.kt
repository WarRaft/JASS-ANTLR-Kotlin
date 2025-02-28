package io.github.warraft.lsp.data

import kotlinx.serialization.Serializable

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#locationLink

@Serializable
data class LocationLink(
    val originSelectionRange: Range? = null,
    val targetUri: String,
    val targetRange: Range,
    val targetSelectionRange: Range,
)
