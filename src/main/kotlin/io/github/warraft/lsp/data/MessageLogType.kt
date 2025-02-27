package io.github.warraft.lsp.data

import io.github.warraft.lsp.serializer.EnumAsIntSerializer
import kotlinx.serialization.Serializable

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#messageType

private class MessageTypeSerializer : EnumAsIntSerializer<MessageLogType>(
    "MessageType",
    { it.value },
    { v -> MessageLogType.entries.first { it.value == v } }
)

@Serializable(with = MessageTypeSerializer::class)
enum class MessageLogType(val value: Int) {
    Error(1),
    Warning(2),
    Info(3),
    Log(4),
    Debug(5)
}
