package io.github.warraft.lsp.data.semantic

// https://code.visualstudio.com/api/language-extensions/semantic-highlight-guide#standard-token-types-and-modifiers
enum class SemanticTokenType {
    NAMESPACE,
    COMMENT,
    FUNCTION,
    VARIABLE,
    PARAMETER,
    KEYWORD,
    TYPE,
    TYPE_PARAMETER,
    NUMBER,
    STRING,
    OPERATOR,
}
