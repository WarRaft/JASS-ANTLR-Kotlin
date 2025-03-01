package io.github.warraft.language._.antlr.state

import io.github.warraft.language._.antlr.utils.LanguageErrorListener
import io.github.warraft.language._.antlr.utils.LanguageTokenFactory
import io.github.warraft.lsp.data.semantic.SemanticTokenHub
import io.github.warraft.language.jass.antlr.utils.JassTokenTree
import io.github.warraft.language.jass.lsp.diagnostic.JassDiagnosticHub
import io.github.warraft.language.jass.lsp.folding.JassFoldingHub
import io.github.warraft.language.jass.lsp.symbol.JassDocumentSymbolHub
import io.github.warraft.lsp.LanguageServer
import io.github.warraft.lsp.data.CompletionList
import io.github.warraft.lsp.data.DocumentHighlight
import io.github.warraft.lsp.data.Hover
import io.github.warraft.lsp.data.Location
import io.github.warraft.lsp.data.LocationLink
import io.github.warraft.lsp.data.Position
import io.github.warraft.lsp.data.TextEdit
import org.antlr.v4.runtime.*

import java.nio.file.Path

abstract class LanguageState {
    var path: Path? = null
    var server: LanguageServer? = null
    var version = -1

    val semanticHub = SemanticTokenHub()
    fun semantic(): MutableList<Int> = semanticHub.data()

    open fun completion(): CompletionList? = null
    open fun hover(position: Position): Hover? = null
    open fun documentHighlight(position: Position): List<DocumentHighlight>? = null
    open fun definition(position: Position): List<LocationLink>? = null
    open fun references(position: Position): List<Location>? = null
    open fun formatting(): List<TextEdit>? = null

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
