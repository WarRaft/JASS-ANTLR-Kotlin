package io.github.warraft.lsp.data

import kotlinx.serialization.Serializable

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#formattingOptions

@Serializable
data class FormattingOptions(
    val tabSize: UInt,
    val insertSpaces: Boolean,
    val trimTrailingWhitespace: Boolean? = null,
    val insertFinalNewline: Boolean? = null,
    val trimFinalNewlines: Boolean? = null,
)
