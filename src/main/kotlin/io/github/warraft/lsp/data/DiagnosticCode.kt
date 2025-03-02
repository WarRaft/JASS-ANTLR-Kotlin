package io.github.warraft.lsp.data

import kotlinx.serialization.Serializable

@Serializable
enum class DiagnosticCode {
    SYNTAX,
    PLUGIN,

    ERROR,
    ARRAY_RETURN
}
