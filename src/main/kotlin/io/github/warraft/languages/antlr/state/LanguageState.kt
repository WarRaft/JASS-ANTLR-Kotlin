package io.github.warraft.languages.antlr.state

import io.github.warraft.jass.antlr.utils.JassTokenTree
import io.github.warraft.jass.lsp4j.diagnostic.JassDiagnosticHub
import io.github.warraft.jass.lsp4j.folding.JassFoldingHub
import io.github.warraft.languages.lsp4j.service.document.semantic.token.SemanticTokenHub
import io.github.warraft.jass.lsp4j.symbol.JassDocumentSymbolHub
import io.github.warraft.languages.lsp4j.LanguageServerEx
import org.antlr.v4.runtime.CharStream
import org.eclipse.lsp4j.CompletionItem
import org.eclipse.lsp4j.DefinitionParams
import org.eclipse.lsp4j.DocumentHighlight
import org.eclipse.lsp4j.DocumentHighlightParams
import org.eclipse.lsp4j.Hover
import org.eclipse.lsp4j.HoverParams
import org.eclipse.lsp4j.Location
import org.eclipse.lsp4j.LocationLink
import org.eclipse.lsp4j.ReferenceParams
import org.eclipse.lsp4j.SignatureHelp
import org.eclipse.lsp4j.SignatureHelpParams
import java.nio.file.Path

abstract class LanguageState {
    var path: Path? = null
    var server: LanguageServerEx? = null
    var version = -1

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

    val semanticHub = SemanticTokenHub()
    fun semantic(): MutableList<Int> = semanticHub.data()

    open fun parse(stream: CharStream, states: List<LanguageState> = listOf(), version: Int? = null) {
        foldingHub.clear()
        diagnosticHub.clear()
        documentSymbolHub.clear()
        tokenTree.clear()
        semanticHub.clear()
    }
}
