package io.github.warraft.lsp.data

import io.github.warraft.lsp.data.ProgressToken

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#progress

data class ProgressParams<T>(val token: ProgressToken, val value: T)
