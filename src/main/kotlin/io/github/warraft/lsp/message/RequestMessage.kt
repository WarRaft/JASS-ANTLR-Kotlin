package io.github.warraft.lsp.message

import io.github.warraft.lsp.serializer.IntOrString
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#requestMessage

@Serializable
data class RequestMessage(
    val id: IntOrString,
    val method: String,
    val params: @Contextual JsonElement?,
) : Message()
