package io.github.warraft.lsp.ext

import io.github.warraft.lsp.LanguageServer
import io.github.warraft.lsp.data.DocumentHighlight
import io.github.warraft.lsp.data.DocumentHighlightParams
import io.github.warraft.lsp.data.Message
import kotlinx.serialization.builtins.ListSerializer
import java.net.URI
import kotlin.io.path.toPath


fun LanguageServer.documentHighlight(message: Message) {
    val params = message.params ?: return
    val p = json.decodeFromJsonElement<DocumentHighlightParams>(DocumentHighlightParams.serializer(), params)
    val path = URI(p.textDocument.uri).toPath()
    val list = stateGet(path)?.documentHighlight(p.position) ?: dummy
    send(
        json.encodeToString(
            Message(
                id = message.id,
                result = json.encodeToJsonElement(ListSerializer(DocumentHighlight.serializer()), list)
            )
        )
    )
}

private val dummy = emptyList<DocumentHighlight>()
