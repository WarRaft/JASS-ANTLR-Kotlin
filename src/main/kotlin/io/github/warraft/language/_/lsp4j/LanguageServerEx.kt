package io.github.warraft.language._.lsp4j

import io.github.warraft.language._.lsp4j.service.document.TextDocumentServiceEx
import org.eclipse.lsp4j.*
import org.eclipse.lsp4j.services.*
import java.util.concurrent.CompletableFuture


class LanguageServerEx(val args: Array<String>) : LanguageServer, LanguageClientAware {
    val textDocumentService = TextDocumentServiceEx(this)

    var client: LanguageClient? = null

    override fun connect(client: LanguageClient) {
        this.client = client
    }

    fun log(message: String) = client?.logMessage(MessageParams(MessageType.Log, message))

    var params: InitializeParams? = null

    override fun initialize(params: InitializeParams?): CompletableFuture<InitializeResult?> {
        this.params = params

        val capabilities = ServerCapabilities().apply {

            //documentSymbolProvider = Either.forRight(DocumentSymbolOptions())

        //diagnosticProvider = DiagnosticRegistrationOptions()

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
    override fun getWorkspaceService(): WorkspaceService? = null
    override fun setTrace(params: SetTraceParams?) = Unit

}
