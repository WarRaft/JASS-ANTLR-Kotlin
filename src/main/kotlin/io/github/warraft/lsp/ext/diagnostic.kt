package io.github.warraft.lsp.ext

import io.github.warraft.lsp.LanguageServer
import io.github.warraft.lsp.data.Diagnostic
import io.github.warraft.lsp.data.DocumentDiagnosticParams
import io.github.warraft.lsp.data.FullDocumentDiagnosticReport
import io.github.warraft.lsp.data.Message
import java.net.URI
import kotlin.io.path.toPath

fun LanguageServer.diagnostic(message: Message) {
    val params = message.params ?: return
    val p = json.decodeFromJsonElement<DocumentDiagnosticParams>(DocumentDiagnosticParams.serializer(), params)
    val path = URI(p.textDocument.uri).toPath()
    val diagnostics = stateGet(path)?.diagnostic

    send(
        json.encodeToString(
            Message(
                id = message.id,
                result = json.encodeToJsonElement(
                    FullDocumentDiagnosticReport.serializer(), FullDocumentDiagnosticReport(
                        items = diagnostics ?: dummy
                    )
                )
            )
        )
    )
}

private val dummy = emptyList<Diagnostic>()
