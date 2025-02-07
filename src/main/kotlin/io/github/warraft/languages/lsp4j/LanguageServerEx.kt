package io.github.warraft.languages.lsp4j

import io.github.warraft.languages.lsp4j.service.document.semantic.token.SemanticTokenModifier
import io.github.warraft.languages.lsp4j.service.document.semantic.token.SemanticTokenType
import io.github.warraft.languages.lsp4j.service.document.TextDocumentServiceEx
import io.github.warraft.jass.lsp4j.service.JassWorkspaceService
import org.eclipse.lsp4j.CompletionOptions
import org.eclipse.lsp4j.DefinitionOptions
import org.eclipse.lsp4j.DiagnosticRegistrationOptions
import org.eclipse.lsp4j.DocumentHighlightOptions
import org.eclipse.lsp4j.DocumentSymbolOptions
import org.eclipse.lsp4j.FoldingRangeProviderOptions
import org.eclipse.lsp4j.HoverOptions
import org.eclipse.lsp4j.InitializeParams
import org.eclipse.lsp4j.InitializeResult
import org.eclipse.lsp4j.MessageParams
import org.eclipse.lsp4j.MessageType
import org.eclipse.lsp4j.ReferenceOptions
import org.eclipse.lsp4j.SemanticTokensLegend
import org.eclipse.lsp4j.SemanticTokensWithRegistrationOptions
import org.eclipse.lsp4j.ServerCapabilities
import org.eclipse.lsp4j.SetTraceParams
import org.eclipse.lsp4j.TextDocumentSyncKind
import org.eclipse.lsp4j.TextDocumentSyncOptions
import org.eclipse.lsp4j.jsonrpc.messages.Either
import org.eclipse.lsp4j.services.LanguageClient
import org.eclipse.lsp4j.services.LanguageClientAware
import org.eclipse.lsp4j.services.LanguageServer
import org.eclipse.lsp4j.services.TextDocumentService
import org.eclipse.lsp4j.services.WorkspaceService
import java.util.concurrent.CompletableFuture

class LanguageServerEx(val args: Array<String>) : LanguageServer, LanguageClientAware {
    private val workspaceService = JassWorkspaceService()
    private val textDocumentService = TextDocumentServiceEx(this)

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

            // https://code.visualstudio.com/api/language-extensions/semantic-highlight-guide
            semanticTokensProvider = SemanticTokensWithRegistrationOptions(
                SemanticTokensLegend(
                    SemanticTokenType.entries.map { it -> case(it.name) },
                    SemanticTokenModifier.entries.map { it -> case(it.name) },
                ),
                true,
            )

            completionProvider = CompletionOptions().apply {
                resolveProvider = true
                triggerCharacters = listOf()
            }
            documentHighlightProvider = Either.forRight(DocumentHighlightOptions())
            foldingRangeProvider = Either.forRight(FoldingRangeProviderOptions())
            documentSymbolProvider = Either.forRight(DocumentSymbolOptions())
            diagnosticProvider = DiagnosticRegistrationOptions()
            hoverProvider = Either.forRight(HoverOptions())
            referencesProvider = Either.forRight(ReferenceOptions())
            definitionProvider = Either.forRight(DefinitionOptions())

            //renameProvider = Either.forRight(RenameOptions())
            //linkedEditingRangeProvider = Either.forRight(LinkedEditingRangeRegistrationOptions())
            //signatureHelpProvider = SignatureHelpOptions(listOf("(", ","))
        }
        return CompletableFuture.completedFuture(InitializeResult(capabilities))
    }

    override fun shutdown(): CompletableFuture<Any> = CompletableFuture.completedFuture(null)
    override fun exit() = Unit
    override fun getTextDocumentService(): TextDocumentService = textDocumentService
    override fun getWorkspaceService(): WorkspaceService = workspaceService
    override fun setTrace(params: SetTraceParams?) = Unit

    companion object {
        private fun case(str: String): String = str.split("_")
            .mapIndexed { index, s -> if (index == 0) s.lowercase() else s.lowercase().replaceFirstChar { it.uppercaseChar() } }.joinToString("")
    }
}
