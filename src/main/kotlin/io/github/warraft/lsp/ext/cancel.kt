package io.github.warraft.lsp.ext

import io.github.warraft.lsp.LanguageServer
import io.github.warraft.lsp.data.CancelParams
import io.github.warraft.lsp.data.Message

fun LanguageServer.cancel(message: Message) {
    val p = message.params ?: return
    val c = json.decodeFromJsonElement<CancelParams>(CancelParams.serializer(), p)
    //log("Cancel: ${c.id}")
}
