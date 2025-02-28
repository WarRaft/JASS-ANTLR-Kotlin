package io.github.warraft.lsp.data

import kotlinx.serialization.Serializable

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#diagnostic

@Serializable
data class Diagnostic(
    val range: Range,
    val severity: DiagnosticSeverity? = null,
    val code: String? = null,
    val codeDescription: CodeDescription? = null,
    val source: String? = null,
    val message: String,
    val tags: List<DiagnosticTag>? = null,
    val relatedInformation: List<DiagnosticRelatedInformation>? = null,
)
