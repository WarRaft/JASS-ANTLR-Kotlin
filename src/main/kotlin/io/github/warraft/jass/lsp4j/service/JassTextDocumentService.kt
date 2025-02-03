package io.github.warraft.jass.lsp4j.service

import io.github.warraft.jass.antlr.state.JassState
import io.github.warraft.jass.antlr.state.ext.completion
import io.github.warraft.jass.antlr.state.ext.documentHighlight
import io.github.warraft.jass.antlr.state.ext.hover
import io.github.warraft.jass.antlr.state.ext.references
import io.github.warraft.jass.lsp4j.JassLanguageServer
import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CharStreams
import org.eclipse.lsp4j.*
import org.eclipse.lsp4j.jsonrpc.messages.Either
import org.eclipse.lsp4j.services.TextDocumentService
import java.net.URI
import java.nio.file.Path
import java.nio.file.Paths
import java.util.concurrent.CompletableFuture
import kotlin.io.path.isReadable
import kotlin.io.path.toPath


class JassTextDocumentService(val server: JassLanguageServer) : TextDocumentService {
    override fun completion(params: CompletionParams?): CompletableFuture<Either<List<CompletionItem>, CompletionList>> =
        CompletableFuture.completedFuture(Either.forLeft(getState(params)?.completion()))

    override fun resolveCompletionItem(unresolved: CompletionItem?): CompletableFuture<CompletionItem> =
        CompletableFuture.completedFuture(unresolved)

    override fun hover(params: HoverParams?): CompletableFuture<Hover> =
        CompletableFuture.completedFuture(getState(params)?.hover(params))

    private val states = mutableMapOf<Path, JassState>()

    override fun references(params: ReferenceParams?): CompletableFuture<MutableList<out Location?>?>? {
        server.log("references ${params?.position}")
        return CompletableFuture.completedFuture(getState(params)?.references(params))
    }

    override fun documentHighlight(params: DocumentHighlightParams?): CompletableFuture<List<DocumentHighlight>> =
        CompletableFuture.completedFuture(getState(params)?.documentHighlight(params))

    override fun rename(params: RenameParams?): CompletableFuture<WorkspaceEdit?>? {
        val edit = WorkspaceEdit()
        server.log("rename ${params?.position}")
        return CompletableFuture.completedFuture(edit)
    }

    override fun linkedEditingRange(params: LinkedEditingRangeParams?): CompletableFuture<LinkedEditingRanges?>? {
        val ranges = mutableListOf<Range>()
        server.log("linkedEditingRange ${params?.position}")
        return CompletableFuture.completedFuture(LinkedEditingRanges(ranges))
    }

    override fun semanticTokensFull(params: SemanticTokensParams?): CompletableFuture<SemanticTokens> =
        CompletableFuture.completedFuture(SemanticTokens(getState(params)?.semanticHub?.data()))

    override fun foldingRange(params: FoldingRangeRequestParams?): CompletableFuture<List<FoldingRange>> =
        CompletableFuture.completedFuture(getState(params)?.foldingHub?.ranges)

    override fun diagnostic(params: DocumentDiagnosticParams?): CompletableFuture<DocumentDiagnosticReport?> =
        CompletableFuture.completedFuture(DocumentDiagnosticReport(RelatedFullDocumentDiagnosticReport(getState(params)?.diagnosticHub?.diagnostics)))

    override fun documentSymbol(params: DocumentSymbolParams?): CompletableFuture<List<Either<SymbolInformation?, DocumentSymbol?>?>?>? =
        CompletableFuture.completedFuture(getState(params)?.documentSymbolHub?.symbols)


    private fun getState(params: DocumentSymbolParams?): JassState? = getState(params?.textDocument?.uri)
    private fun getState(params: DocumentDiagnosticParams?): JassState? = getState(params?.textDocument?.uri)
    private fun getState(params: FoldingRangeRequestParams?): JassState? = getState(params?.textDocument?.uri)
    private fun getState(params: SemanticTokensParams?): JassState? = getState(params?.textDocument?.uri)
    private fun getState(params: TextDocumentPositionAndWorkDoneProgressParams?): JassState? = getState(params?.textDocument?.uri)
    private fun getState(params: TextDocumentPositionAndWorkDoneProgressAndPartialResultParams?): JassState? = getState(params?.textDocument?.uri)
    private fun getState(uri: String?): JassState? = if (uri == null) null else states[URI(uri).toPath()]

    private fun getStateAndParse(
        path: Path,
        stream: CharStream,
        list: List<JassState> = listOf(),
        noparse: Boolean,
    ): JassState {
        val s = states.getOrPut(path) { JassState() }
        if (noparse && s.nodeMap.isNotEmpty()) return s
        try {
            s.parse(stream, list)
        } catch (e: Exception) {
            server.log("Error! ${e.message}")
            server.log("Trace! ${e.stackTrace}")
        }
        return s
    }

    private fun stateUpdate(uri: String, text: String) {
        val path = URI(uri).toPath()
        val list = mutableListOf<JassState>()

        val folder = server.args.getOrNull(1)
        if (folder != null) {
            for (f in listOf("common.j", "blizzard.j")) {
                val p = Paths.get(folder, f)
                if (p == path) {
                    getStateAndParse(path, CharStreams.fromString(text), list, false)
                    return
                }
                if (!p.isReadable()) continue
                list.add(getStateAndParse(p, CharStreams.fromPath(p), list, true))
            }
        }

        getStateAndParse(path, CharStreams.fromString(text), list, false)
    }

    override fun didOpen(params: DidOpenTextDocumentParams) {
        stateUpdate(params.textDocument.uri, params.textDocument.text)
    }

    override fun didClose(params: DidCloseTextDocumentParams) {
    }

    override fun didChange(params: DidChangeTextDocumentParams) {
        if (params.contentChanges.isEmpty()) return
        val uri = params.textDocument.uri
        val e = params.contentChanges.last()
        stateUpdate(uri, e.text)
    }

    override fun didSave(params: DidSaveTextDocumentParams) {
    }
}
