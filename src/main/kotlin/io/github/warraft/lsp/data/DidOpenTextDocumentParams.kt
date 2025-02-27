package io.github.warraft.lsp.data

import kotlinx.serialization.Serializable

@Serializable
class DidOpenTextDocumentParams(val textDocument: TextDocumentItem)
