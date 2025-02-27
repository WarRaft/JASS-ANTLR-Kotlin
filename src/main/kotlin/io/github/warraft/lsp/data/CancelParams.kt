package io.github.warraft.lsp.data

import io.github.warraft.lsp.serializer.IntOrString
import kotlinx.serialization.Serializable

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#cancelRequest

@Serializable
class CancelParams {
    val id: IntOrString? = null
}
