package io.github.warraft.lsp.data

import kotlinx.serialization.Serializable

@Serializable
data class DocumentDiagnosticParams(
    val textDocument: TextDocumentIdentifier,
    val identifier: String? = null,
    val previousResultId: String? = null,
)
