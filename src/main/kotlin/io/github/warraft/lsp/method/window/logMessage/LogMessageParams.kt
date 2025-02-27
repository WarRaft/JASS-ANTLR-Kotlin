package io.github.warraft.lsp.method.window.logMessage

import io.github.warraft.lsp.method.window.MessageType
import io.github.warraft.lsp.utils.Params
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#window_logMessage

@Serializable
data class LogMessageParams(val type: MessageType, val message: String) : Params {
    @Transient
    override val method: String = "window/logMessage"
}
