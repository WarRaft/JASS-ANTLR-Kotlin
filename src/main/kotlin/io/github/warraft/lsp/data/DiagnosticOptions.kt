package io.github.warraft.lsp.data

import kotlinx.serialization.Serializable

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#diagnosticOptions

@Serializable
data class DiagnosticOptions(
    val identifier: String? = null,
    val interFileDependencies: Boolean = true,
    val workspaceDiagnostics: Boolean = true,
)
