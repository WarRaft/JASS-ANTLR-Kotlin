package io.github.warraft.lsp.message

import kotlinx.serialization.Serializable

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#message

@Serializable
open class Message {
    val jsonrpc: String = "2.0"
}
