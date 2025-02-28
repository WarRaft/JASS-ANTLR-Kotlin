package io.github.warraft.language._.lsp4j.service.document

import io.github.warraft.language._.lsp4j.LanguageServerEx
import org.eclipse.lsp4j.DidChangeTextDocumentParams
import org.eclipse.lsp4j.DidCloseTextDocumentParams
import org.eclipse.lsp4j.DidOpenTextDocumentParams
import org.eclipse.lsp4j.DidSaveTextDocumentParams
import org.eclipse.lsp4j.services.TextDocumentService

class TextDocumentServiceEx(val server: LanguageServerEx) : TextDocumentService {

    //override fun diagnostic(params: DocumentDiagnosticParams?): CompletableFuture<DocumentDiagnosticReport?> = completedFuture(DocumentDiagnosticReport(RelatedFullDocumentDiagnosticReport(stateGet(params)?.diagnosticHub?.diagnostics)))

    //override fun definition(params: DefinitionParams?): CompletableFuture<Either<MutableList<out Location?>?, MutableList<out LocationLink?>?>?>? = completedFuture(Either.forRight(stateGet(params)?.definition(params)))
    //override fun references(params: ReferenceParams?): CompletableFuture<MutableList<out Location?>?>? = completedFuture(stateGet(params)?.references(params))
    //override fun formatting(params: DocumentFormattingParams?): CompletableFuture<List<TextEdit?>?>? = completedFuture(stateGet(params)?.formatting(params))

    override fun didOpen(params: DidOpenTextDocumentParams) {
    }

    override fun didChange(params: DidChangeTextDocumentParams) {
    }

    override fun didSave(params: DidSaveTextDocumentParams) {
    }

    override fun didClose(params: DidCloseTextDocumentParams) {
    }
}
