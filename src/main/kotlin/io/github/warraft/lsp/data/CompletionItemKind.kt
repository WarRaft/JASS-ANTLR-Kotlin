package io.github.warraft.lsp.data

import io.github.warraft.lsp.serializer.EnumAsIntSerializer
import kotlinx.serialization.Serializable

private class CompletionItemKindSerializer : EnumAsIntSerializer<CompletionItemKind>(
    "CompletionItemKind",
    { it.value },
    { v -> CompletionItemKind.entries.first { it.value == v } }
)

@Serializable(with = CompletionItemKindSerializer::class)
enum class CompletionItemKind(val value: Int) {
    Text(1),
    Method(2),
    Function(3),
    Constructor(4),
    Field(5),
    Variable(6),
    Class(7),
    Interface(8),
    Module(9),
    Property(10),
    Unit(11),
    Value(12),
    Enum(13),
    Keyword(14),
    Snippet(15),
    Color(16),
    File(17),
    Reference(18),
    Folder(19),
    EnumMember(20),
    Constant(21),
    Struct(22),
    Event(23),
    Operator(24),
    TypeParameter(25),
}
