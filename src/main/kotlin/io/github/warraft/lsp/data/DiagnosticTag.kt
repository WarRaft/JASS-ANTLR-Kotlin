package io.github.warraft.lsp.data

import io.github.warraft.lsp.serializer.EnumAsIntSerializer
import kotlinx.serialization.Serializable

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#diagnosticTag

private class DiagnosticTagSerializer : EnumAsIntSerializer<DiagnosticTag>(
    "DiagnosticTag",
    { it.value },
    { v -> DiagnosticTag.entries.first { it.value == v } }
)

@Serializable(with = DiagnosticTagSerializer::class)
enum class DiagnosticTag(val value: Int) {
    Unnecessary(1),
    Deprecated(2)
}
