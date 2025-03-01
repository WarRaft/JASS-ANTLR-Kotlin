package io.github.warraft.lsp.data

import kotlinx.serialization.Serializable

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#referenceParams

@Serializable
data class ReferenceParams(val context: ReferenceContext) : TextDocumentPositionParams()
