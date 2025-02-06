package io.github.warraft.jass.antlr.state

import io.github.warraft.JassLexer
import io.github.warraft.JassParser
import io.github.warraft.JassParser.*
import io.github.warraft.jass.antlr.psi.JassFun
import io.github.warraft.jass.antlr.psi.JassHandleType
import io.github.warraft.jass.antlr.psi.JassVar
import io.github.warraft.jass.antlr.psi.base.JassNodeBase
import io.github.warraft.jass.antlr.state.ext.antlr.function
import io.github.warraft.jass.antlr.state.ext.antlr.global
import io.github.warraft.jass.antlr.state.ext.antlr.typedef
import io.github.warraft.jass.antlr.state.ext.lsp4j.completionExt
import io.github.warraft.jass.antlr.state.ext.lsp4j.definitionExt
import io.github.warraft.jass.antlr.state.ext.lsp4j.documentHighlightExt
import io.github.warraft.jass.antlr.state.ext.lsp4j.hoverExt
import io.github.warraft.jass.antlr.state.ext.lsp4j.referencesExt
import io.github.warraft.jass.antlr.state.ext.lsp4j.signatureHelpExt
import io.github.warraft.jass.antlr.utils.JassErrorListener
import io.github.warraft.jass.antlr.utils.JassTokenFactory
import io.github.warraft.jass.lsp4j.semantic.JassSemanticTokenType
import io.github.warraft.languages.lsp4j.LanguageServerEx
import io.github.warraft.languages.lsp4j.antlr.state.LanguageState
import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CommonToken
import org.antlr.v4.runtime.CommonTokenStream
import org.eclipse.lsp4j.*

class JassState : LanguageState() {
    var states: MutableList<JassState> = mutableListOf()

    val typeMap: MutableMap<String, JassHandleType> = mutableMapOf()
    val types: MutableList<JassHandleType> = mutableListOf()

    val natives: MutableList<JassFun> = mutableListOf()
    val globals: MutableList<JassVar> = mutableListOf()
    val functions: MutableList<JassFun> = mutableListOf()

    val nodeMap: MutableMap<String, JassNodeBase> = mutableMapOf()
    override fun nodeCount(): Int = nodeMap.size

    override fun completion(): List<CompletionItem> = completionExt()
    override fun hover(params: HoverParams?): Hover? = hoverExt(params)
    override fun signatureHelp(params: SignatureHelpParams?): SignatureHelp? = signatureHelpExt(params)
    override fun definition(params: DefinitionParams?): MutableList<LocationLink> = definitionExt(params)
    override fun documentHighlight(params: DocumentHighlightParams?): List<DocumentHighlight> = documentHighlightExt(params)
    override fun references(params: ReferenceParams?): MutableList<out Location?> = referencesExt(params)

    val commentsMap = mutableMapOf<Int, CommonToken>()

    override fun parse(stream: CharStream, states: List<LanguageState>) {
        this.states.clear()
        for (s in states) {
            if (s is JassState) this.states.add(s)
        }

        types.clear()
        typeMap.clear()
        natives.clear()
        globals.clear()
        functions.clear()
        nodeMap.clear()

        commentsMap.clear()

        super.parse(stream, states)

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

    fun root(ctx: RootContext): JassNodeBase? {
        ctx.children.forEach {
            when (it) {
                is GlobalsContext -> {
                    val sgctx = it.GLOBALS()
                    val egctx = it.ENDGLOBALS()

                    foldingHub.add(sgctx, egctx)
                    semanticHub
                        .add(sgctx, JassSemanticTokenType.KEYWORD)
                        .add(egctx, JassSemanticTokenType.KEYWORD)
                    it.variable().forEach(::global)
                }

                is TypeContext -> typedef(it)
                is NativeRuleContext -> function(it)
                is FunctionContext -> function(it)
            }
        }
        return null
    }
}

