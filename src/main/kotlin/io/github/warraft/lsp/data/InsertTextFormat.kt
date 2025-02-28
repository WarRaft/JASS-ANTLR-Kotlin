package io.github.warraft.lsp.data

import io.github.warraft.lsp.serializer.EnumAsIntSerializer
import kotlinx.serialization.Serializable

private class InsertTextFormatSerializer : EnumAsIntSerializer<InsertTextFormat>(
    "InsertTextFormat",
    { it.value },
    { v -> InsertTextFormat.entries.first { it.value == v } }
)

@Serializable(with = InsertTextFormatSerializer::class)
enum class InsertTextFormat(val value: Int) {
    PlainText(1),
    Snippet(2)
}
