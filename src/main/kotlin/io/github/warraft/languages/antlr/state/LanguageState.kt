package io.github.warraft.languages.antlr.state

import io.github.warraft.jass.antlr.utils.JassTokenTree
import io.github.warraft.jass.lsp4j.diagnostic.JassDiagnosticHub
import io.github.warraft.jass.lsp4j.folding.JassFoldingHub
import io.github.warraft.jass.lsp4j.symbol.JassDocumentSymbolHub
import io.github.warraft.languages.antlr.utils.LanguageErrorListener
import io.github.warraft.languages.antlr.utils.LanguageTokenFactory
import io.github.warraft.languages.lsp4j.LanguageServerEx
import io.github.warraft.languages.lsp4j.service.document.semantic.token.SemanticTokenHub
import org.antlr.v4.runtime.*
import org.eclipse.lsp4j.*
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
    open fun formatting(params: DocumentFormattingParams?): List<TextEdit> = listOf()

    val foldingHub = JassFoldingHub()
    val diagnosticHub = JassDiagnosticHub()
    val documentSymbolHub = JassDocumentSymbolHub()
    val tokenTree = JassTokenTree()

    val semanticHub = SemanticTokenHub()
    fun semantic(): MutableList<Int> = semanticHub.data()

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
