package io.github.warraft.jass.lsp4j.semantic

import io.github.warraft.jass.lsp4j.semantic.JassSemanticTokenModifier

class JassSemanticToken(
    val line: Int,
    val pos: Int,
    val len: Int,
    val type: JassSemanticTokenType,
    val modifier: JassSemanticTokenModifier? = null,
    )
