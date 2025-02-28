package io.github.warraft.lsp.data.semantic

class SemanticTokenLine(val index: Int) {
    val tokens = mutableListOf<SemanticToken>()

    fun add(token: SemanticToken) {
        tokens.add(token)
    }
}
