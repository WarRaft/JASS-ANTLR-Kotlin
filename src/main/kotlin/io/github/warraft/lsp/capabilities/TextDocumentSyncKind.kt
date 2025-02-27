package io.github.warraft.lsp.capabilities

import io.github.warraft.lsp.serializer.EnumAsIntSerializer
import kotlinx.serialization.Serializable

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#textDocumentSyncKind

private class TextDocumentSyncKindSerializer : EnumAsIntSerializer<TextDocumentSyncKind>(
    "TextDocumentSyncKind",
    { it.value },
    { v -> TextDocumentSyncKind.entries.first { it.value == v } }
)

@Serializable(with = TextDocumentSyncKindSerializer::class)
enum class TextDocumentSyncKind(val value: Int) {
    None(0),
    Full(1),
    Incremental(2),
}
