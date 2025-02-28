package io.github.warraft.language._.lsp4j.service.document

import io.github.warraft.language._.antlr.state.LanguageState
import io.github.warraft.language._.lsp4j.LanguageServerEx
import io.github.warraft.language._.lsp4j.service.document.ext.stateGet
import org.eclipse.lsp4j.*
import org.eclipse.lsp4j.jsonrpc.messages.Either
import org.eclipse.lsp4j.services.TextDocumentService
import java.nio.file.Path
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletableFuture.completedFuture

class TextDocumentServiceEx(val server: LanguageServerEx) : TextDocumentService {

    internal val sdkStateList = mutableListOf<LanguageState>()
    internal val languageMap = mutableMapOf<Path, String>()
    internal val stateMap = mutableMapOf<Path, LanguageState>()

    override fun diagnostic(params: DocumentDiagnosticParams?): CompletableFuture<DocumentDiagnosticReport?> = completedFuture(DocumentDiagnosticReport(RelatedFullDocumentDiagnosticReport(stateGet(params)?.diagnosticHub?.diagnostics)))
    override fun documentSymbol(params: DocumentSymbolParams?): CompletableFuture<List<Either<SymbolInformation?, DocumentSymbol?>?>?>? = completedFuture(stateGet(params)?.documentSymbolHub?.symbols)


    override fun definition(params: DefinitionParams?): CompletableFuture<Either<MutableList<out Location?>?, MutableList<out LocationLink?>?>?>? = completedFuture(Either.forRight(stateGet(params)?.definition(params)))
    override fun references(params: ReferenceParams?): CompletableFuture<MutableList<out Location?>?>? = completedFuture(stateGet(params)?.references(params))
    override fun formatting(params: DocumentFormattingParams?): CompletableFuture<List<TextEdit?>?>? = completedFuture(stateGet(params)?.formatting(params))

    override fun didOpen(params: DidOpenTextDocumentParams) {
    }

    override fun didChange(params: DidChangeTextDocumentParams) {
    }

    override fun didSave(params: DidSaveTextDocumentParams) {
    }

    override fun didClose(params: DidCloseTextDocumentParams) {
    }
}
