package io.github.warraft.lsp.ext

import io.github.warraft.lsp.LanguageServer
import io.github.warraft.lsp.data.DocumentSymbol
import io.github.warraft.lsp.data.DocumentSymbolParams
import io.github.warraft.lsp.data.Message
import kotlinx.serialization.builtins.ListSerializer
import java.net.URI
import kotlin.io.path.toPath

fun LanguageServer.documentSymbol(message: Message) {
    val params = message.params ?: return
    val p = json.decodeFromJsonElement<DocumentSymbolParams>(DocumentSymbolParams.serializer(), params)
    val path = URI(p.textDocument.uri).toPath()
    val symbols = stateGet(path)?.documentSymbol
    send(
        json.encodeToString(
            Message(
                id = message.id,
                result = json.encodeToJsonElement(ListSerializer(DocumentSymbol.serializer()), symbols ?: dummy)
            )
        )
    )
}

private val dummy = emptyList<DocumentSymbol>()
