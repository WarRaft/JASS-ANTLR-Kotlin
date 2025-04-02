package io.github.warraft.lsp.data

import kotlinx.serialization.Serializable

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#inlayHintLabelPart

@Serializable
data class InlayHintLabelPart(
    val value: String,
    val tooltip: MarkupContent? = null,
    val location: Location? = null,
    //command?: Command;
)
