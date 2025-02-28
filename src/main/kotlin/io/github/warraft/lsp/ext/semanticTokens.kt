package io.github.warraft.lsp.ext

import io.github.warraft.lsp.LanguageServer
import io.github.warraft.lsp.data.Message
import io.github.warraft.lsp.data.SemanticTokens
import io.github.warraft.lsp.data.SemanticTokensParams
import java.net.URI
import kotlin.io.path.toPath

fun LanguageServer.semanticTokens(message: Message) {
    val params = message.params ?: return
    val p = json.decodeFromJsonElement<SemanticTokensParams>(SemanticTokensParams.serializer(), params)
    val path = URI(p.textDocument.uri).toPath()
    send(
        json.encodeToString(
            Message(
                id = message.id,
                result = json.encodeToJsonElement(SemanticTokens.serializer(), SemanticTokens(data = stateGet(path)?.semantic() ?: emptyList()))
            )
        )
    )
}
