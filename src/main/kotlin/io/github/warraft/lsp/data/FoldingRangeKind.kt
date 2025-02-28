package io.github.warraft.lsp.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#foldingRangeKind

@Serializable
enum class FoldingRangeKind {

    @SerialName("comment")
    Comment,

    @SerialName("imports")
    Imports,

    @SerialName("region")
    Region,
}
