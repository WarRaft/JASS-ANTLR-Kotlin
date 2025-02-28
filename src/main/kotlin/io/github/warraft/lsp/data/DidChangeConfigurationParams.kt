package io.github.warraft.lsp.data

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#didChangeConfigurationParams

@Serializable
class DidChangeConfigurationParams(val settings: JsonElement)
