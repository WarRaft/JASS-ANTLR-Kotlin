@file:OptIn(ExperimentalSerializationApi::class)

package io.github.warraft.lsp.data

import kotlinx.serialization.EncodeDefault
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#fullDocumentDiagnosticReport

@Serializable
data class FullDocumentDiagnosticReport(
    @EncodeDefault val kind: DocumentDiagnosticReportKind = DocumentDiagnosticReportKind.Full,
    val resultId: String? = null,
    val items: List<Diagnostic>,
)
