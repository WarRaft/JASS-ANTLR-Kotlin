package io.github.warraft.language._.lsp4j.service.document

import io.github.warraft.language._.antlr.state.LanguageState
import io.github.warraft.language._.lsp4j.LanguageServerEx
import io.github.warraft.language._.lsp4j.service.document.ext.stateGet
import io.github.warraft.language._.lsp4j.service.document.ext.stateUpdate
import org.eclipse.lsp4j.*
import org.eclipse.lsp4j.jsonrpc.messages.Either
import org.eclipse.lsp4j.services.TextDocumentService
import java.net.URI
import java.nio.file.Path
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletableFuture.completedFuture
import kotlin.io.path.toPath

class TextDocumentServiceEx(val server: LanguageServerEx) : TextDocumentService {

    internal val sdkStateList = mutableListOf<LanguageState>()
    internal val languageMap = mutableMapOf<Path, String>()
    internal val stateMap = mutableMapOf<Path, LanguageState>()

    override fun foldingRange(params: FoldingRangeRequestParams?): CompletableFuture<List<FoldingRange>> = completedFuture(stateGet(params)?.foldingHub?.ranges)
    override fun diagnostic(params: DocumentDiagnosticParams?): CompletableFuture<DocumentDiagnosticReport?> = completedFuture(DocumentDiagnosticReport(RelatedFullDocumentDiagnosticReport(stateGet(params)?.diagnosticHub?.diagnostics)))
    override fun documentSymbol(params: DocumentSymbolParams?): CompletableFuture<List<Either<SymbolInformation?, DocumentSymbol?>?>?>? = completedFuture(stateGet(params)?.documentSymbolHub?.symbols)
    override fun completion(params: CompletionParams?): CompletableFuture<Either<List<CompletionItem>, CompletionList>> = completedFuture(Either.forLeft(stateGet(params)?.completion()))
    override fun resolveCompletionItem(unresolved: CompletionItem?): CompletableFuture<CompletionItem> = completedFuture(unresolved)
    override fun hover(params: HoverParams?): CompletableFuture<Hover> = completedFuture(stateGet(params)?.hover(params))
    override fun signatureHelp(params: SignatureHelpParams?): CompletableFuture<SignatureHelp?>? = completedFuture(stateGet(params)?.signatureHelp(params))
    override fun definition(params: DefinitionParams?): CompletableFuture<Either<MutableList<out Location?>?, MutableList<out LocationLink?>?>?>? = completedFuture(Either.forRight(stateGet(params)?.definition(params)))
    override fun documentHighlight(params: DocumentHighlightParams?): CompletableFuture<List<DocumentHighlight>> = completedFuture(stateGet(params)?.documentHighlight(params))
    override fun references(params: ReferenceParams?): CompletableFuture<MutableList<out Location?>?>? = completedFuture(stateGet(params)?.references(params))
    override fun formatting(params: DocumentFormattingParams?): CompletableFuture<List<TextEdit?>?>? = completedFuture(stateGet(params)?.formatting(params))

    override fun rename(params: RenameParams?): CompletableFuture<WorkspaceEdit?>? {
        val edit = WorkspaceEdit()
        server.log("rename ${params?.position}")
        return completedFuture(edit)
    }

    override fun linkedEditingRange(params: LinkedEditingRangeParams?): CompletableFuture<LinkedEditingRanges?>? {
        val ranges = mutableListOf<Range>()
        server.log("linkedEditingRange ${params?.position}")
        return completedFuture(LinkedEditingRanges(ranges))
    }

    override fun didOpen(params: DidOpenTextDocumentParams) {
        val doc = params.textDocument
        val path = URI(doc.uri).toPath()
        languageMap[path] = doc.languageId
        stateUpdate(
            path,
            doc.text,
            doc.version
        )
    }

    override fun didChange(params: DidChangeTextDocumentParams) {
        if (params.contentChanges.isEmpty()) return
        val doc = params.textDocument
        stateUpdate(
            URI(doc.uri).toPath(),
            params.contentChanges.last().text,
            doc.version
        )
    }

    override fun didSave(params: DidSaveTextDocumentParams) {
    }

    override fun didClose(params: DidCloseTextDocumentParams) {
    }
}
