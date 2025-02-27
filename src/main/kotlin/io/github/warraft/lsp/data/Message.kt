package io.github.warraft.lsp.data

import io.github.warraft.lsp.serializer.IntOrString
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#message

@Serializable
data class Message(
    @Suppress("unused") val jsonrpc: String = "2.0",
    val id: IntOrString? = null,
    // https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#requestMessage
    val method: String? = null,
    val params: @Contextual JsonElement? = null,
    // https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#responseMessage
    val result: @Contextual JsonElement? = null,
    val error: @Contextual JsonElement? = null,
)
