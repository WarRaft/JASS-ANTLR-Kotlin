package io.github.warraft.languages.lsp4j

import com.google.gson.JsonObject
import io.github.warraft.languages.lsp4j.service.WorkspaceServiceEx
import io.github.warraft.languages.lsp4j.service.document.TextDocumentServiceEx
import io.github.warraft.languages.lsp4j.service.document.semantic.token.SemanticTokenModifier
import io.github.warraft.languages.lsp4j.service.document.semantic.token.SemanticTokenType
import org.eclipse.lsp4j.*
import org.eclipse.lsp4j.jsonrpc.messages.Either
import org.eclipse.lsp4j.services.*
import java.util.concurrent.CompletableFuture

class tds : TextDocumentService {
    override fun didOpen(params: DidOpenTextDocumentParams?) {
    }

    override fun didChange(params: DidChangeTextDocumentParams?) {
    }

    override fun didClose(params: DidCloseTextDocumentParams?) {
    }

    override fun didSave(params: DidSaveTextDocumentParams?) {

    }
}

class LanguageServerEx(val args: Array<String>) : LanguageServer, LanguageClientAware {
    private val workspaceService = WorkspaceServiceEx(this)

    //val textDocumentService = TextDocumentServiceEx(this)
    val textDocumentService = tds()

    var client: LanguageClient? = null

    override fun connect(client: LanguageClient) {
        this.client = client
    }

    @Suppress("unused")
    fun log(message: String) = client?.logMessage(MessageParams(MessageType.Log, message))

    var params: InitializeParams? = null

    override fun initialize(params: InitializeParams?): CompletableFuture<InitializeResult?> {
        this.params = params

        val opt = params?.initializationOptions

        try {
            if (opt is JsonObject) workspaceService.didChangeSDK(opt["settings"] as? JsonObject)
        } catch (e: Throwable) {
            client?.showMessage(MessageParams(MessageType.Error, e.stackTraceToString()))
        }

        val capabilities = ServerCapabilities().apply {
            textDocumentSync = Either.forRight(TextDocumentSyncOptions().apply {
                openClose = true
                change = TextDocumentSyncKind.Full
            })

            //workspace = WorkspaceServerCapabilities()

            // https://code.visualstudio.com/api/language-extensions/semantic-highlight-guide
            /*
            semanticTokensProvider = SemanticTokensWithRegistrationOptions(
                SemanticTokensLegend(
                    SemanticTokenType.entries.map { it -> case(it.name) },
                    SemanticTokenModifier.entries.map { it -> case(it.name) },
                ),
                true,
            )

             */

            /*
            completionProvider = CompletionOptions().apply {
                resolveProvider = true
                triggerCharacters = listOf()
            }

             */
            //documentHighlightProvider = Either.forRight(DocumentHighlightOptions())
            //foldingRangeProvider = Either.forRight(FoldingRangeProviderOptions())
            //documentSymbolProvider = Either.forRight(DocumentSymbolOptions())
            //diagnosticProvider = DiagnosticRegistrationOptions()
            //hoverProvider = Either.forRight(HoverOptions())
            //referencesProvider = Either.forRight(ReferenceOptions())
            //definitionProvider = Either.forRight(DefinitionOptions())

            //documentFormattingProvider = Either.forRight(DocumentFormattingOptions())


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
