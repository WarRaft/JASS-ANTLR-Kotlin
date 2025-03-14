package io.github.warraft.lsp.data

import kotlinx.serialization.Serializable

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#semanticTokensOptions

@Serializable
data class SemanticTokensOptions(
    val range: Boolean? = null,
    val full: Boolean? = null,
    val legend : SemanticTokensLegend,
)
