package io.github.warraft.lsp.data

import kotlinx.serialization.Serializable

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#location

@Serializable
class Location(
    val uri: String,
    val range: Range,
)

