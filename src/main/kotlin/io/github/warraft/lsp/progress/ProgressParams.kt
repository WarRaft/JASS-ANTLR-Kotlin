package io.github.warraft.lsp.progress

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#progress

data class ProgressParams<T>(val token: ProgressToken, val value: T)
