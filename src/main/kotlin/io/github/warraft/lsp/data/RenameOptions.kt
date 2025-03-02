package io.github.warraft.lsp.data

import kotlinx.serialization.Serializable

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#renameOptions

@Serializable
data class RenameOptions(val prepareProvider: Boolean? = null)
