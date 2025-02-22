package io.github.warraft.jass.antlr.state

import io.github.warraft.JassLexer
import io.github.warraft.JassParser
import io.github.warraft.JassParser.*
import io.github.warraft.jass.antlr.psi.*
import io.github.warraft.jass.antlr.psi.base.JassNodeBase
import io.github.warraft.jass.antlr.state.ext.antlr.typedef
import io.github.warraft.jass.antlr.state.ext.lsp4j.*
import io.github.warraft.jass.antlr.utils.JassErrorListener
import io.github.warraft.languages.antlr.state.LanguageState
import io.github.warraft.languages.antlr.utils.LanguageTokenFactory
import io.github.warraft.languages.lsp4j.service.document.semantic.token.SemanticTokenType
import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CommonToken
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.ParserRuleContext
import org.eclipse.lsp4j.*

class JassState : LanguageState() {
    val states: MutableList<JassState> = mutableListOf()

    val typeMap: MutableMap<String, JassHandleType> = mutableMapOf()
    val types: MutableList<JassHandleType> = mutableListOf()

    val natives: MutableList<JassFun> = mutableListOf()
    val globals: MutableList<JassVar> = mutableListOf()
    val functions: MutableList<JassFun> = mutableListOf()

    val varScope = JassVarScope(this)
    val funScope = JassFunScope(this)

    val funMap: MutableMap<String, JassFun> = mutableMapOf()

    override fun completion(): List<CompletionItem> = completionExt()
    override fun hover(params: HoverParams?): Hover? = hoverExt(params)
    override fun signatureHelp(params: SignatureHelpParams?): SignatureHelp? = signatureHelpExt(params)
    override fun definition(params: DefinitionParams?): MutableList<LocationLink> = definitionExt(params)
    override fun documentHighlight(params: DocumentHighlightParams?): List<DocumentHighlight> = documentHighlightExt(params)
    override fun references(params: ReferenceParams?): MutableList<out Location?> = referencesExt(params)
    override fun formatting(params: DocumentFormattingParams?): List<TextEdit> = formattingEx(params)

    val commentsMap = mutableMapOf<Int, CommonToken>()

    lateinit var root: RootContext

    override fun parse(stream: CharStream, states: List<LanguageState>, version: Int?) {
        if (version != null) {
            if (version == this.version) return
            this.version = version
        }

        this.states.clear()
        for (s in states) {
            if (s is JassState) this.states.add(s)
        }

        typeMap.clear()
        types.clear()
        natives.clear()
        globals.clear()
        functions.clear()
        varScope.clear()
        funScope.clear()
        funMap.clear()
        commentsMap.clear()

        super.parse(stream, states, version)

        val errorJassErrorListener = JassErrorListener()

        val lexer = JassLexer(stream)
        lexer.removeErrorListeners()
        lexer.addErrorListener(errorJassErrorListener)
        val f = LanguageTokenFactory(commentsMap)
        lexer.tokenFactory = f

        val tokens = CommonTokenStream(lexer)

        val parser = JassParser(tokens)
        parser.removeErrorListeners()
        parser.addErrorListener(errorJassErrorListener)

        root = parser.root()
        root()

        for (c in f.comments) {
            if (!commentsMap.containsKey(c.line)) continue
            semanticHub.add(c, SemanticTokenType.COMMENT)
        }

        diagnosticHub.diagnostics.addAll(errorJassErrorListener.diagnostics)
    }

    fun root(): JassNodeBase? {
        root.children.forEach {
            when (it) {
                is GlobalsContext -> {
                    val globalsCtx = it.GLOBALS()
                    val endglobalsCtx = it.ENDGLOBALS()

                    foldingHub.add(globalsCtx, endglobalsCtx)
                    semanticHub
                        .add(globalsCtx, SemanticTokenType.KEYWORD)
                        .add(endglobalsCtx, SemanticTokenType.KEYWORD)

                    for (ctx in it.variable()) JassVar.parse(ctx, null, this)
                }

                is TypeContext -> typedef(it)
                is NativeRuleContext -> JassFun.parse(it, null, this)
                is FunctionContext -> JassFun.parse(it, null, this)
            }
        }
        return null
    }
}
