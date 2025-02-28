package io.github.warraft.lsp.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#markupContent

@Serializable
enum class MarkupKind {
    @SerialName("plaintext")
    PlainText,

    @SerialName("markdown")
    Markdown
}
