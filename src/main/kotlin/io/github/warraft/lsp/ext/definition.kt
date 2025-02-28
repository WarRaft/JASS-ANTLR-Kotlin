package io.github.warraft.lsp.ext

import io.github.warraft.lsp.LanguageServer
import io.github.warraft.lsp.data.DefinitionParams
import io.github.warraft.lsp.data.LocationLink
import io.github.warraft.lsp.data.Message
import kotlinx.serialization.builtins.ListSerializer
import java.net.URI
import kotlin.io.path.toPath

fun LanguageServer.definition(message: Message) {
    val params = message.params ?: return
    val p = json.decodeFromJsonElement<DefinitionParams>(DefinitionParams.serializer(), params)
    val path = URI(p.textDocument.uri).toPath()
    val folding = stateGet(path)?.definition(p.position)
    send(
        json.encodeToString(
            Message(
                id = message.id,
                result = json.encodeToJsonElement(ListSerializer(LocationLink.serializer()), folding ?: dummy)
            )
        )
    )
}

private val dummy = emptyList<LocationLink>()

