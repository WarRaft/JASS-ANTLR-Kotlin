package io.github.warraft.language._.lsp4j.service.document.semantic.token

class SemanticTokenLine(val index: Int) {
    val tokens = mutableListOf<SemanticToken>()

    fun add(token: SemanticToken) {
        tokens.add(token)
    }
}
