package io.github.warraft.lsp.data

import io.github.warraft.lsp.serializer.EnumAsIntSerializer
import kotlinx.serialization.Serializable

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#documentHighlightKind

private class DocumentHighlightKindSerializer : EnumAsIntSerializer<DocumentHighlightKind>(
    "DocumentHighlightKind",
    { it.value },
    { v -> DocumentHighlightKind.entries.first { it.value == v } }
)

@Serializable(with = DocumentHighlightKindSerializer::class)
enum class DocumentHighlightKind(val value: Int) {
    Text(1),
    Read(2),
    Write(3)
}
