package io.github.warraft.lsp.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#documentDiagnosticReportKind

@Serializable
enum class DocumentDiagnosticReportKind {
    @SerialName("full")
    Full,

    @SerialName("unchanged")
    Unchanged
}
