package io.github.warraft.lsp.ext

import io.github.warraft.lsp.LanguageServer
import io.github.warraft.lsp.data.CompletionList
import io.github.warraft.lsp.data.CompletionParams
import io.github.warraft.lsp.data.Message
import java.net.URI
import kotlin.io.path.toPath

fun LanguageServer.completion(message: Message) {
    val params = message.params ?: return
    val p = json.decodeFromJsonElement<CompletionParams>(CompletionParams.serializer(), params)
    val path = URI(p.textDocument.uri).toPath()
    val list = stateGet(path)?.also {
        it.completion()
    }?.completion ?: dummy

    send(
        json.encodeToString(
            Message(
                id = message.id,
                result = json.encodeToJsonElement(CompletionList.serializer(), list)
            )
        )
    )
}

private val dummy = CompletionList()
