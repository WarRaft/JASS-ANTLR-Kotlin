package io.github.warraft.lsp.ext

import io.github.warraft.lsp.LanguageServer
import io.github.warraft.lsp.data.DidOpenTextDocumentParams
import io.github.warraft.lsp.data.Message
import java.net.URI
import kotlin.io.path.toPath

fun LanguageServer.didOpen(message: Message) {
    val params = message.params ?: return
    val p = json.decodeFromJsonElement<DidOpenTextDocumentParams>(DidOpenTextDocumentParams.serializer(), params)
    val doc = p.textDocument
    val path = URI(doc.uri).toPath()
    languageMap[path] = doc.languageId
    stateUpdate(
        path,
        doc.text,
        doc.version
    )
}
