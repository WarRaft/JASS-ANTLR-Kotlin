package io.github.warraft.lsp.ext

import io.github.warraft.lsp.LanguageServer
import io.github.warraft.lsp.data.DocumentFormattingParams
import io.github.warraft.lsp.data.Message
import io.github.warraft.lsp.data.TextEdit
import kotlinx.serialization.builtins.ListSerializer
import java.net.URI
import kotlin.io.path.toPath

fun LanguageServer.formatting(message: Message) {
    val params = message.params ?: return
    val p = json.decodeFromJsonElement<DocumentFormattingParams>(DocumentFormattingParams.serializer(), params)
    val path = URI(p.textDocument.uri).toPath()
    val formatting = stateGet(path)?.formatting()
    send(
        json.encodeToString(
            Message(
                id = message.id,
                result = json.encodeToJsonElement(ListSerializer(TextEdit.serializer()), formatting ?: dummy)
            )
        )
    )
}

private val dummy = emptyList<TextEdit>()

