package io.github.warraft.lsp.data

import kotlinx.serialization.Serializable

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#inlayHint

@Serializable
data class InlayHint(
    val position: Position,
    val label: List<InlayHintLabelPart>,
    //kind?: InlayHintKind;
    val textEdits: List<TextEdit>? = null,
    val tooltip: MarkupContent? = null,
    val paddingLeft: Boolean? = null,
    val paddingRight: Boolean? = null,
)
