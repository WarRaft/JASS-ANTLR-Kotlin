package io.github.warraft.languages.lsp4j.service.document

import io.github.warraft.jass.antlr.state.JassState
import io.github.warraft.languages.lsp4j.LanguageServerEx
import io.github.warraft.languages.antlr.state.LanguageState
import io.github.warraft.vex.antlr.state.VexState
import io.github.warraft.vex.antlr.state.VjassState
import io.github.warraft.vex.antlr.state.ZincState
import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CharStreams
import org.eclipse.lsp4j.CompletionItem
import org.eclipse.lsp4j.CompletionList
import org.eclipse.lsp4j.CompletionParams
import org.eclipse.lsp4j.DefinitionParams
import org.eclipse.lsp4j.DidChangeTextDocumentParams
import org.eclipse.lsp4j.DidCloseTextDocumentParams
import org.eclipse.lsp4j.DidOpenTextDocumentParams
import org.eclipse.lsp4j.DidSaveTextDocumentParams
import org.eclipse.lsp4j.DocumentDiagnosticParams
import org.eclipse.lsp4j.DocumentDiagnosticReport
import org.eclipse.lsp4j.DocumentHighlight
import org.eclipse.lsp4j.DocumentHighlightParams
import org.eclipse.lsp4j.DocumentSymbol
import org.eclipse.lsp4j.DocumentSymbolParams
import org.eclipse.lsp4j.FoldingRange
import org.eclipse.lsp4j.FoldingRangeRequestParams
import org.eclipse.lsp4j.Hover
import org.eclipse.lsp4j.HoverParams
import org.eclipse.lsp4j.LinkedEditingRangeParams
import org.eclipse.lsp4j.LinkedEditingRanges
import org.eclipse.lsp4j.Location
import org.eclipse.lsp4j.LocationLink
import org.eclipse.lsp4j.Range
import org.eclipse.lsp4j.ReferenceParams
import org.eclipse.lsp4j.RelatedFullDocumentDiagnosticReport
import org.eclipse.lsp4j.RenameParams
import org.eclipse.lsp4j.SemanticTokens
import org.eclipse.lsp4j.SemanticTokensParams
import org.eclipse.lsp4j.SignatureHelp
import org.eclipse.lsp4j.SignatureHelpParams
import org.eclipse.lsp4j.SymbolInformation
import org.eclipse.lsp4j.TextDocumentIdentifier
import org.eclipse.lsp4j.TextDocumentPositionAndWorkDoneProgressAndPartialResultParams
import org.eclipse.lsp4j.TextDocumentPositionAndWorkDoneProgressParams
import org.eclipse.lsp4j.WorkspaceEdit
import org.eclipse.lsp4j.jsonrpc.messages.Either
import org.eclipse.lsp4j.services.TextDocumentService
import java.net.URI
import java.nio.file.Path
import java.nio.file.Paths
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletableFuture.*
import kotlin.io.path.extension
import kotlin.io.path.isReadable
import kotlin.io.path.toPath

class TextDocumentServiceEx(val server: LanguageServerEx) : TextDocumentService {

    override fun semanticTokensFull(params: SemanticTokensParams?): CompletableFuture<SemanticTokens> = completedFuture(SemanticTokens(getState(params)?.semantic()))
    override fun foldingRange(params: FoldingRangeRequestParams?): CompletableFuture<List<FoldingRange>> = completedFuture(getState(params)?.foldingHub?.ranges)
    override fun diagnostic(params: DocumentDiagnosticParams?): CompletableFuture<DocumentDiagnosticReport?> = completedFuture(DocumentDiagnosticReport(RelatedFullDocumentDiagnosticReport(getState(params)?.diagnosticHub?.diagnostics)))
    override fun documentSymbol(params: DocumentSymbolParams?): CompletableFuture<List<Either<SymbolInformation?, DocumentSymbol?>?>?>? = completedFuture(getState(params)?.documentSymbolHub?.symbols)
    override fun completion(params: CompletionParams?): CompletableFuture<Either<List<CompletionItem>, CompletionList>> = completedFuture(Either.forLeft(getState(params)?.completion()))
    override fun resolveCompletionItem(unresolved: CompletionItem?): CompletableFuture<CompletionItem> = completedFuture(unresolved)
    override fun hover(params: HoverParams?): CompletableFuture<Hover> = completedFuture(getState(params)?.hover(params))
    override fun signatureHelp(params: SignatureHelpParams?): CompletableFuture<SignatureHelp?>? = completedFuture(getState(params)?.signatureHelp(params))
    override fun definition(params: DefinitionParams?): CompletableFuture<Either<MutableList<out Location?>?, MutableList<out LocationLink?>?>?>? = completedFuture(Either.forRight(getState(params)?.definition(params)))
    override fun documentHighlight(params: DocumentHighlightParams?): CompletableFuture<List<DocumentHighlight>> = completedFuture(getState(params)?.documentHighlight(params))
    override fun references(params: ReferenceParams?): CompletableFuture<MutableList<out Location?>?>? = completedFuture(getState(params)?.references(params))

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

    private fun getState(params: DocumentSymbolParams?): LanguageState? = getState(params?.textDocument)
    private fun getState(params: DocumentDiagnosticParams?): LanguageState? = getState(params?.textDocument)
    private fun getState(params: FoldingRangeRequestParams?): LanguageState? = getState(params?.textDocument)
    private fun getState(params: SemanticTokensParams?): LanguageState? = getState(params?.textDocument)
    private fun getState(params: TextDocumentPositionAndWorkDoneProgressParams?): LanguageState? = getState(params?.textDocument)
    private fun getState(params: TextDocumentPositionAndWorkDoneProgressAndPartialResultParams?): LanguageState? = getState(params?.textDocument)
    private fun getState(textDocument: TextDocumentIdentifier?): LanguageState? = getState(textDocument?.uri)
    private fun getState(uri: String?): LanguageState? = if (uri == null) null else getState(URI(uri).toPath())
    private fun getState(p: Path): LanguageState {
        var state = states[p]
        when (p.extension) {
            "j" -> if (state !is JassState) state = JassState()
            "vj" -> if (state !is VjassState) state = VjassState()
            "zn" -> if (state !is ZincState) state = ZincState()
        }
        if (state == null) return object : LanguageState() {
            override fun nodeCount(): Int = 0
        }
        states[p] = state.also {
            it.path = p
            it.server = server
        }
        return state
    }

    private fun getStateAndParse(
        path: Path,
        stream: CharStream,
        list: List<LanguageState> = listOf(),
        noparse: Boolean,
    ): LanguageState {
        val s = getState(path)
        if (noparse && s.nodeCount() > 0) return s
        try {
            s.parse(stream, list)
        } catch (e: Exception) {
            server.log("Error! ${e.message}")
            server.log("Trace! ${e.stackTrace}")
        }
        return s
    }

    private val states = mutableMapOf<Path, LanguageState>()

    private fun stateUpdate(uri: String, text: String) {
        val path = URI(uri).toPath()
        val list = mutableListOf<LanguageState>()

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
