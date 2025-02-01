package io.github.warraft.jass.lsp4j.semantic

class JassSemanticTokenLine(val index: Int) {
    val tokens = mutableListOf<JassSemanticToken>()

    fun add(token: JassSemanticToken) {
        tokens.add(token)
    }
}
