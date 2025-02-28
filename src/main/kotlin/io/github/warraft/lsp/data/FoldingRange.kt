package io.github.warraft.lsp.data

import kotlinx.serialization.Serializable

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#foldingRange

@Serializable
data class FoldingRange(
    val startLine: UInt,
    val startCharacter: UInt? = null,
    val endLine: UInt,
    val endCharacter: UInt? = null,
    val kind: FoldingRangeKind? = null,
    val collapsedText: String? = null,
)
