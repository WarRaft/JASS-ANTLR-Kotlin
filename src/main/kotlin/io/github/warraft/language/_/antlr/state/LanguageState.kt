package io.github.warraft.language._.antlr.state

import io.github.warraft.language._.antlr.utils.LanguageErrorListener
import io.github.warraft.language._.antlr.utils.LanguageTokenFactory
import io.github.warraft.language._.lsp4j.LanguageServerEx
import io.github.warraft.language._.lsp4j.service.document.semantic.token.SemanticTokenHub
import io.github.warraft.language.jass.antlr.utils.JassTokenTree
import io.github.warraft.language.jass.lsp4j.diagnostic.JassDiagnosticHub
import io.github.warraft.language.jass.lsp4j.folding.JassFoldingHub
import io.github.warraft.language.jass.lsp4j.symbol.JassDocumentSymbolHub
import io.github.warraft.lsp.data.CompletionList
import io.github.warraft.lsp.data.DocumentHighlight
import io.github.warraft.lsp.data.Position
import org.antlr.v4.runtime.*
import org.eclipse.lsp4j.DefinitionParams
import org.eclipse.lsp4j.DocumentFormattingParams
import org.eclipse.lsp4j.Hover
import org.eclipse.lsp4j.HoverParams
import org.eclipse.lsp4j.Location
import org.eclipse.lsp4j.LocationLink
import org.eclipse.lsp4j.ReferenceParams
import org.eclipse.lsp4j.SignatureHelp
import org.eclipse.lsp4j.SignatureHelpParams
import org.eclipse.lsp4j.TextEdit

import java.nio.file.Path

abstract class LanguageState {
    var path: Path? = null
    var server: LanguageServerEx? = null
    var version = -1

    val semanticHub = SemanticTokenHub()
    fun semantic(): MutableList<Int> = semanticHub.data()

    open fun completion(): CompletionList? = null
    open fun documentHighlight(position: Position): List<DocumentHighlight>? = null

    open fun hover(params: HoverParams?): Hover? = null
    open fun signatureHelp(params: SignatureHelpParams?): SignatureHelp? = null
    open fun definition(params: DefinitionParams?): MutableList<LocationLink> = mutableListOf()
    open fun references(params: ReferenceParams?): MutableList<out Location?> = mutableListOf()
    open fun formatting(params: DocumentFormattingParams?): List<TextEdit> = listOf()

    val foldingHub = JassFoldingHub()
    val diagnosticHub = JassDiagnosticHub()
    val documentSymbolHub = JassDocumentSymbolHub()
    val tokenTree = JassTokenTree()

    lateinit var lexer: Lexer
    abstract fun lexer(stream: CharStream): Lexer

    lateinit var parser: Parser
    abstract fun parser(stream: CommonTokenStream): Parser

    lateinit var rootCtx: ParserRuleContext

    val errorListener = LanguageErrorListener()
    val tokenFactory = LanguageTokenFactory()
    lateinit var tokenStream: CommonTokenStream

    open fun parse(stream: CharStream, states: List<LanguageState> = listOf(), version: Int?) {
        foldingHub.clear()
        diagnosticHub.clear()
        documentSymbolHub.clear()
        tokenTree.clear()
        semanticHub.clear()

        errorListener.clear()
        tokenFactory.clear()

        lexer = lexer(stream).also {
            it.tokenFactory = tokenFactory
            it.removeErrorListeners()
            it.addErrorListener(errorListener)
        }

        tokenStream = CommonTokenStream(lexer)

        parser = parser(tokenStream).also {
            it.removeErrorListeners()
            it.addErrorListener(errorListener)
        }
    }

    fun needParse(version: Int?): Boolean {
        if (version == null) return true
        if (version == this.version) return false
        this.version = version
        return true
    }
}
