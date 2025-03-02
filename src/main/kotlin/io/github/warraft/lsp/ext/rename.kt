package io.github.warraft.lsp.ext

import io.github.warraft.lsp.LanguageServer
import io.github.warraft.lsp.data.Message
import io.github.warraft.lsp.data.RenameParams
import io.github.warraft.lsp.data.WorkspaceEdit
import kotlinx.serialization.json.JsonNull
import java.net.URI
import kotlin.io.path.toPath

fun LanguageServer.rename(message: Message) {
    val params = message.params ?: return
    val p = json.decodeFromJsonElement<RenameParams>(RenameParams.serializer(), params)
    val path = URI(p.textDocument.uri).toPath()
    val edit = stateGet(path)?.rename(p)
    send(
        json.encodeToString(
            Message(
                id = message.id,
                result = if (edit == null) JsonNull else json.encodeToJsonElement(WorkspaceEdit.serializer(), edit)
            )
        )
    )
}
