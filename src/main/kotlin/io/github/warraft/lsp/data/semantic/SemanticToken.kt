package io.github.warraft.lsp.data.semantic

import io.github.warraft.lsp.data.semantic.SemanticTokenModifier
import io.github.warraft.lsp.data.semantic.SemanticTokenType

class SemanticToken(
    val line: Int,
    val pos: Int,
    val len: Int,
    val type: SemanticTokenType,
    val modifier: SemanticTokenModifier? = null,
)
