package io.github.warraft.lsp.data

import io.github.warraft.lsp.serializer.EnumAsIntSerializer
import kotlinx.serialization.Serializable

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#completionTriggerKind

private class CompletionTriggerKindSerializer : EnumAsIntSerializer<CompletionTriggerKind>(
    "CompletionTriggerKind",
    { it.value },
    { v -> CompletionTriggerKind.entries.first { it.value == v } }
)

@Serializable(with = CompletionTriggerKindSerializer::class)
enum class CompletionTriggerKind(val value: Int) {
    Invoked(1),
    TriggerCharacter(2),
    TriggerForIncompleteCompletions(3)
}
