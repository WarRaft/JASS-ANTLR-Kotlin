package io.github.warraft.lsp.ext

import io.github.warraft.lsp.LanguageServer
import io.github.warraft.lsp.data.DidChangeTextDocumentParams
import io.github.warraft.lsp.data.Message
import java.net.URI
import kotlin.io.path.toPath

fun LanguageServer.didChange(message: Message) {
    val params = message.params ?: return
    val p = json.decodeFromJsonElement<DidChangeTextDocumentParams>(DidChangeTextDocumentParams.serializer(), params)
    if (p.contentChanges.isEmpty()) return
    val doc = p.textDocument
    stateUpdate(
        URI(doc.uri).toPath(),
        p.contentChanges.last().text,
        doc.version
    )
}
