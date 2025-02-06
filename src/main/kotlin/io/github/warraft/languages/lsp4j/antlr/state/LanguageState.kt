package io.github.warraft.languages.lsp4j.antlr.state

import io.github.warraft.jass.antlr.utils.JassTokenTree
import io.github.warraft.jass.lsp4j.diagnostic.JassDiagnosticHub
import io.github.warraft.jass.lsp4j.folding.JassFoldingHub
import io.github.warraft.jass.lsp4j.semantic.JassSemanticTokenHub
import io.github.warraft.jass.lsp4j.symbol.JassDocumentSymbolHub
import org.antlr.v4.runtime.CharStream
import org.eclipse.lsp4j.*
import org.eclipse.lsp4j.services.LanguageServer
import java.nio.file.Path

abstract class LanguageState {
    var path: Path? = null
    var server: LanguageServer? = null

    abstract fun nodeCount(): Int

    open fun completion(): List<CompletionItem> = mutableListOf<CompletionItem>()
    open fun hover(params: HoverParams?): Hover? = null
    open fun signatureHelp(params: SignatureHelpParams?): SignatureHelp? = null
    open fun definition(params: DefinitionParams?): MutableList<LocationLink> = mutableListOf()
    open fun documentHighlight(params: DocumentHighlightParams?): List<DocumentHighlight> = listOf()
    open fun references(params: ReferenceParams?): MutableList<out Location?> = mutableListOf()

    val foldingHub = JassFoldingHub()
    val diagnosticHub = JassDiagnosticHub()
    val documentSymbolHub = JassDocumentSymbolHub()
    val tokenTree = JassTokenTree()

    val semanticHub = JassSemanticTokenHub()
    fun semantic(): MutableList<Int> = semanticHub.data()

    open fun parse(stream: CharStream, states: List<LanguageState> = listOf()) {
        foldingHub.clear()
        diagnosticHub.clear()
        documentSymbolHub.clear()
        tokenTree.clear()
        semanticHub.clear()
    }
}

