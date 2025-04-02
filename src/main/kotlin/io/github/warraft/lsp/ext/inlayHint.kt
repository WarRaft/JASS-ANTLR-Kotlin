package io.github.warraft.lsp.ext

import io.github.warraft.lsp.LanguageServer
import io.github.warraft.lsp.data.InlayHint
import io.github.warraft.lsp.data.InlayHintParams
import io.github.warraft.lsp.data.Message
import kotlinx.serialization.builtins.ListSerializer
import java.net.URI
import kotlin.io.path.toPath

fun LanguageServer.inlayHint(message: Message) {
    val params = message.params ?: return
    val p: InlayHintParams = json.decodeFromJsonElement<InlayHintParams>(InlayHintParams.serializer(), params)
    val path = URI(p.textDocument.uri).toPath()
    val inlayHint =
        stateGet(path)?.inlayHint?.filter { it.position.line >= p.range.start.line && it.position.line <= p.range.end.line }

    send(
        json.encodeToString(
            Message(
                id = message.id,
                result = json.encodeToJsonElement(ListSerializer(InlayHint.serializer()), inlayHint ?: dummy)
            )
        )
    )
}

private val dummy = emptyList<InlayHint>()
