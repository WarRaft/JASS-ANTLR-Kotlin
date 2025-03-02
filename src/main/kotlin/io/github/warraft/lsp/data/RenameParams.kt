package io.github.warraft.lsp.data

import kotlinx.serialization.Serializable

@Serializable
class RenameParams(val newName: String) : TextDocumentPositionParams()
