package io.github.warraft.lsp.data

import io.github.warraft.language.jass.psi.base.JassNodeBase
import kotlinx.serialization.Serializable

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#diagnostic

@Serializable
data class Diagnostic(
    val range: Range,
    val severity: DiagnosticSeverity? = null,
    val code: DiagnosticCode? = null,
    val codeDescription: CodeDescription? = null,
    val source: String? = null,
    val message: String,
    val tags: List<DiagnosticTag>? = null,
    var relatedInformation: MutableList<DiagnosticRelatedInformation>? = null,
) {
    fun relatedInformation(information: DiagnosticRelatedInformation?) {
        if (information == null) return
        relatedInformation?.add(information) ?: run { relatedInformation = mutableListOf(information) }
    }

    fun relatedInformation(node: JassNodeBase?, message: String) {
        val l = Location.of(node, node?.definition) ?: return
        relatedInformation(
            DiagnosticRelatedInformation(
                location = l,
                message = message,
            )
        )
    }
}
