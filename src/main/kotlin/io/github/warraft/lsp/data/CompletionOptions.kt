package io.github.warraft.lsp.data

import kotlinx.serialization.Serializable

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#completionOptions

@Serializable
data class CompletionOptions(
    val triggerCharacters: List<String>? = null,
    val allCommitCharacters: List<String>? = null,
    val resolveProvider: Boolean? = null,
    val completionItem: CompletionItem? = null,
) {
    @Serializable
    data class CompletionItem(val labelDetailsSupport: Boolean? = null)
}
