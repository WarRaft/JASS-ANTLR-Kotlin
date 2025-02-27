package io.github.warraft.language._.lsp4j.service.document.semantic.token

class SemanticToken(
    val line: Int,
    val pos: Int,
    val len: Int,
    val type: SemanticTokenType,
    val modifier: SemanticTokenModifier? = null,
)
