package io.github.warraft.lsp.data

import io.github.warraft.lsp.serializer.EnumAsIntSerializer
import kotlinx.serialization.Serializable

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#symbolKind

private class SymbolKindSerializer : EnumAsIntSerializer<SymbolKind>(
    "SymbolKind",
    { it.value },
    { v -> SymbolKind.entries.first { it.value == v } }
)

@Serializable(with = SymbolKindSerializer::class)
enum class SymbolKind(val value: Int) {
    File(1),
    Module(2),
    Namespace(3),
    Package(4),
    Class(5),
    Method(6),
    Property(7),
    Field(8),
    Constructor(9),
    Enum(10),
    Interface(11),
    Function(12),
    Variable(13),
    Constant(14),
    String(15),
    Number(16),
    Boolean(17),
    Array(18),
    Object(19),
    Key(20),
    Null(21),
    EnumMember(22),
    Struct(23),
    Event(24),
    Operator(25),
    TypeParameter(26),
}
