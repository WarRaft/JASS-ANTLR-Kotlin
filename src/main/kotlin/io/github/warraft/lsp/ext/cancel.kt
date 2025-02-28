package io.github.warraft.lsp.ext

import io.github.warraft.lsp.LanguageServer
import io.github.warraft.lsp.data.CancelParams
import io.github.warraft.lsp.data.Message

fun LanguageServer.cancel(message: Message) {
    val params = message.params ?: return
    val p = json.decodeFromJsonElement<CancelParams>(CancelParams.serializer(), params)
    //log("Cancel: ${c.id}")
}
