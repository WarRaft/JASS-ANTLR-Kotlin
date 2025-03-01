package io.github.warraft.lsp.ext

import io.github.warraft.lsp.LanguageServer
import io.github.warraft.lsp.data.Location
import io.github.warraft.lsp.data.Message
import io.github.warraft.lsp.data.ReferenceParams
import kotlinx.serialization.builtins.ListSerializer
import java.net.URI
import kotlin.io.path.toPath

fun LanguageServer.references(message: Message) {
    val params = message.params ?: return
    val p = json.decodeFromJsonElement<ReferenceParams>(ReferenceParams.serializer(), params)
    val path = URI(p.textDocument.uri).toPath()
    val references = stateGet(path)?.references(p.position)
    send(
        json.encodeToString(
            Message(
                id = message.id,
                result = json.encodeToJsonElement(ListSerializer(Location.serializer()), references ?: dummy)
            )
        )
    )
}

private val dummy = emptyList<Location>()

