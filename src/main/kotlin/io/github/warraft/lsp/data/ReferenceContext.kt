package io.github.warraft.lsp.data

import kotlinx.serialization.Serializable

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#referenceContext

@Serializable
class ReferenceContext(val includeDeclaration: Boolean)
