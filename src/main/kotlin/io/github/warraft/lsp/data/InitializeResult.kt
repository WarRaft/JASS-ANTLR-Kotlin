package io.github.warraft.lsp.data

import kotlinx.serialization.Serializable

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#initializeResult

@Serializable
data class InitializeResult(val capabilities: ServerCapabilities) {
    @Suppress("unused")
    val serverInfo = mapOf(
        "name" to "JASS-ANTLR-Kotlin",
        "version" to "0.0.1",
    )
}
