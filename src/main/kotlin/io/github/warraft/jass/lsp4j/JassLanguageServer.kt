package io.github.warraft.jass.lsp4j

import io.github.warraft.jass.lsp4j.semantic.JassSemanticTokenModifier
import io.github.warraft.jass.lsp4j.semantic.JassSemanticTokenType
import io.github.warraft.jass.lsp4j.service.JassWorkspaceService
import io.github.warraft.jass.lsp4j.service.JassTextDocumentService
import org.eclipse.lsp4j.*
import org.eclipse.lsp4j.jsonrpc.messages.Either
import org.eclipse.lsp4j.services.*

import java.util.concurrent.CompletableFuture

class JassLanguageServer(val args: Array<String>) : LanguageServer, LanguageClientAware {
    private val workspaceService = JassWorkspaceService()
    private val textDocumentService = JassTextDocumentService(this)

    var client: LanguageClient? = null

    override fun connect(client: LanguageClient) {
        this.client = client
    }

    @Suppress("unused")
    fun log(message: String) = client?.logMessage(MessageParams(MessageType.Log, message))

    override fun initialize(params: InitializeParams?): CompletableFuture<InitializeResult?> {
        val capabilities = ServerCapabilities().apply {
            textDocumentSync = Either.forRight(TextDocumentSyncOptions().apply {
                openClose = true
                change = TextDocumentSyncKind.Full
            })

            completionProvider = CompletionOptions().apply {
                resolveProvider = true
                triggerCharacters = listOf(".", "(")
            }

            // https://code.visualstudio.com/api/language-extensions/semantic-highlight-guide
            semanticTokensProvider = SemanticTokensWithRegistrationOptions().apply {
                legend = SemanticTokensLegend(
                    JassSemanticTokenType.entries.map { it ->
                        it.name.split("_")
                            .mapIndexed { index, s ->
                                if (index == 0) s.lowercase() else s.lowercase().replaceFirstChar { it.uppercaseChar() }
                            }
                            .joinToString("")
                    },
                    JassSemanticTokenModifier.entries.map { it -> it.name.lowercase() },
                )
                full = Either.forLeft(true)
            }

            documentHighlightProvider = Either.forRight(DocumentHighlightOptions())
            foldingRangeProvider = Either.forRight(FoldingRangeProviderOptions())
            documentSymbolProvider = Either.forRight(DocumentSymbolOptions())
            diagnosticProvider = DiagnosticRegistrationOptions()
            hoverProvider = Either.forRight(HoverOptions())
            //renameProvider = Either.forRight(RenameOptions())
            //linkedEditingRangeProvider = Either.forRight(LinkedEditingRangeRegistrationOptions())
            referencesProvider = Either.forRight(ReferenceOptions())
            definitionProvider = Either.forRight(DefinitionOptions())
        }
        return CompletableFuture.completedFuture(InitializeResult(capabilities))
    }

    override fun shutdown(): CompletableFuture<Any> = CompletableFuture.completedFuture(null)
    override fun exit() = Unit
    override fun getTextDocumentService(): TextDocumentService = textDocumentService
    override fun getWorkspaceService(): WorkspaceService = workspaceService
    override fun setTrace(params: SetTraceParams?) = Unit
}
