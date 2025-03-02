package io.github.warraft.lsp.ext

import io.github.warraft.lsp.LanguageServer
import io.github.warraft.lsp.data.FoldingRange
import io.github.warraft.lsp.data.FoldingRangeParams
import io.github.warraft.lsp.data.Message
import kotlinx.serialization.builtins.ListSerializer
import java.net.URI
import kotlin.io.path.toPath

fun LanguageServer.foldingRange(message: Message) {
    val params = message.params ?: return
    val p = json.decodeFromJsonElement<FoldingRangeParams>(FoldingRangeParams.serializer(), params)
    val path = URI(p.textDocument.uri).toPath()
    val folding = stateGet(path)?.foldingRange
    send(
        json.encodeToString(
            Message(
                id = message.id,
                result = json.encodeToJsonElement(ListSerializer(FoldingRange.serializer()), folding ?: dummy)
            )
        )
    )
}

private val dummy = emptyList<FoldingRange>()
