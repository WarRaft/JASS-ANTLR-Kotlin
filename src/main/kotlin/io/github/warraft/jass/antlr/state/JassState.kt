package io.github.warraft.jass.antlr.state

import io.github.warraft.jass.antlr.JassLexer
import io.github.warraft.jass.antlr.JassParser
import io.github.warraft.jass.antlr.psi.JassFun
import io.github.warraft.jass.antlr.psi.JassHandleType
import io.github.warraft.jass.antlr.psi.JassVar
import io.github.warraft.jass.antlr.psi.base.JassNodeBase
import io.github.warraft.jass.antlr.state.ext.function
import io.github.warraft.jass.antlr.state.ext.global
import io.github.warraft.jass.antlr.state.ext.typedef
import io.github.warraft.jass.antlr.utils.JassErrorListener
import io.github.warraft.jass.antlr.utils.JassTokenFactory
import io.github.warraft.jass.antlr.utils.JassTokenTree
import io.github.warraft.jass.lsp4j.diagnostic.JassDiagnosticHub
import io.github.warraft.jass.lsp4j.folding.JassFoldingHub
import io.github.warraft.jass.lsp4j.semantic.JassSemanticTokenHub
import io.github.warraft.jass.lsp4j.semantic.JassSemanticTokenType
import io.github.warraft.jass.lsp4j.symbol.JassDocumentSymbolHub
import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CommonToken
import org.antlr.v4.runtime.CommonTokenStream
import java.nio.file.Path

class JassState {
    var states: List<JassState> = listOf()

    var path: Path? = null

    val typeMap: MutableMap<String, JassHandleType> = mutableMapOf()
    val types: MutableList<JassHandleType> = mutableListOf()

    val natives: MutableList<JassFun> = mutableListOf()
    val globals: MutableList<JassVar> = mutableListOf()
    val functions: MutableList<JassFun> = mutableListOf()

    val nodeMap: MutableMap<String, JassNodeBase> = mutableMapOf()

    val semanticHub = JassSemanticTokenHub()
    val foldingHub = JassFoldingHub()
    val diagnosticHub = JassDiagnosticHub()
    val documentSymbolHub = JassDocumentSymbolHub()
    val tokenTree = JassTokenTree()
    val commentsMap = mutableMapOf<Int, CommonToken>()

    fun parse(stream: CharStream, states: List<JassState> = listOf()) {
        this.states = states

        types.clear()
        typeMap.clear()
        natives.clear()
        globals.clear()
        functions.clear()
        nodeMap.clear()

        semanticHub.clear()
        foldingHub.clear()
        diagnosticHub.clear()
        documentSymbolHub.clear()
        tokenTree.clear()
        commentsMap.clear()

        val errorJassErrorListener = JassErrorListener()

        val lexer = JassLexer(stream)
        lexer.removeErrorListeners()
        lexer.addErrorListener(errorJassErrorListener)
        val f = JassTokenFactory(commentsMap)
        lexer.tokenFactory = f

        val tokens = CommonTokenStream(lexer)

        val parser = JassParser(tokens)
        parser.removeErrorListeners()
        parser.addErrorListener(errorJassErrorListener)
        root(parser.root())

        for (c in f.comments) {
            if (!commentsMap.containsKey(c.line)) continue
            semanticHub.add(c, JassSemanticTokenType.COMMENT)
        }

        diagnosticHub.diagnostics.addAll(errorJassErrorListener.diagnostics)
    }

    fun getNode(key: String, f: JassFun?): JassNodeBase? {
        if (f != null) {
            for (p in f.param.asReversed()) {
                if (p.name == key) return p
            }
        }
        states.forEach {
            if (it.nodeMap.containsKey(key)) {
                return it.nodeMap[key]
            }
        }
        if (nodeMap.containsKey(key)) {
            return nodeMap[key]
        }
        return null
    }

    fun root(ctx: JassParser.RootContext): JassNodeBase? {
        ctx.children.forEach {
            when (it) {
                is JassParser.GlobalsContext -> {
                    val sgctx = it.GLOBALS()
                    val egctx = it.ENDGLOBALS()

                    foldingHub.add(sgctx, egctx)
                    semanticHub
                        .add(sgctx, JassSemanticTokenType.KEYWORD)
                        .add(egctx, JassSemanticTokenType.KEYWORD)
                    it.variable().forEach(::global)
                }

                is JassParser.TypeContext -> typedef(it)
                is JassParser.NativeRuleContext -> function(it)
                is JassParser.FunctionContext -> function(it)
            }
        }
        return null
    }
}

