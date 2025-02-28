package io.github.warraft.lsp.ext

import io.github.warraft.lsp.LanguageServer
import io.github.warraft.lsp.data.Hover
import io.github.warraft.lsp.data.HoverParams
import io.github.warraft.lsp.data.Message
import kotlinx.serialization.json.JsonNull
import java.net.URI
import kotlin.io.path.toPath

fun LanguageServer.hover(message: Message) {
    val params = message.params ?: return
    val p = json.decodeFromJsonElement<HoverParams>(HoverParams.serializer(), params)
    val path = URI(p.textDocument.uri).toPath()
    val hover = stateGet(path)?.hover(p.position)
    send(
        json.encodeToString(
            Message(
                id = message.id,
                result = if (hover == null) JsonNull else json.encodeToJsonElement(Hover.serializer(), hover)
            )
        )
    )
}
