package io.github.warraft.jass.lsp4j.semantic

// https://code.visualstudio.com/api/language-extensions/semantic-highlight-guide#standard-token-types-and-modifiers
enum class JassSemanticTokenType {
    COMMENT,
    FUNCTION,
    VARIABLE,
    PARAMETER,
    KEYWORD,
    TYPE,
    NUMBER,
    STRING,
    OPERATOR,
}
