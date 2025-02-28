package io.github.warraft.lsp.data

import io.github.warraft.lsp.serializer.EnumAsIntSerializer
import kotlinx.serialization.Serializable

private class DiagnosticSeveritySerializer : EnumAsIntSerializer<DiagnosticSeverity>(
    "DiagnosticSeverity",
    { it.value },
    { v -> DiagnosticSeverity.entries.first { it.value == v } }
)

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#diagnosticSeverity

@Serializable(with = DiagnosticSeveritySerializer::class)
enum class DiagnosticSeverity(val value: Int) {
    Error(1),
    Warning(2),
    Information(3),
    Hint(4)
}
