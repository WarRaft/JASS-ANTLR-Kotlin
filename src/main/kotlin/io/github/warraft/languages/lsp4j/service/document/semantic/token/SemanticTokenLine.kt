package io.github.warraft.languages.lsp4j.service.document.semantic.token

class SemanticTokenLine(val index: Int) {
    val tokens = mutableListOf<SemanticToken>()

    fun add(token: SemanticToken) {
        tokens.add(token)
    }
}
