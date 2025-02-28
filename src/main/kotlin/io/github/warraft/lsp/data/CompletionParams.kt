package io.github.warraft.lsp.data

import kotlinx.serialization.Serializable

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#completionParams

@Serializable
data class CompletionParams(val context: CompletionContext?) : TextDocumentPositionParams() {
    override fun toString(): String = "doc:$textDocument | p:$position | ctx:$context"
}
