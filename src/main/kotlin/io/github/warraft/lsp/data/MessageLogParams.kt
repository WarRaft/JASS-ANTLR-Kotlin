package io.github.warraft.lsp.data

import kotlinx.serialization.Serializable

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#window_showMessage

@Serializable
data class MessageLogParams(val type: MessageLogType, val message: String) {
    companion object {
        const val SHOW = "window/showMessage"
        const val LOG = "window/logMessage"
    }
}
