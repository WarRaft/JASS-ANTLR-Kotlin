package io.github.warraft.lsp.data

import kotlinx.serialization.Serializable

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#semanticTokens

@Serializable
data class SemanticTokens(
    val resultId: String? = null,
    val data: List<Int>,
)
