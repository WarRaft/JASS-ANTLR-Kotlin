package io.github.warraft.language.jass.antlr.state

import io.github.warraft.JassLexer
import io.github.warraft.JassParser
import io.github.warraft.JassParser.*
import io.github.warraft.language._.antlr.state.LanguageState
import io.github.warraft.language._.lsp4j.service.document.semantic.token.SemanticTokenType
import io.github.warraft.language.jass.antlr.psi.JassFun
import io.github.warraft.language.jass.antlr.psi.JassFunScope
import io.github.warraft.language.jass.antlr.psi.JassType
import io.github.warraft.language.jass.antlr.psi.JassTypeScope
import io.github.warraft.language.jass.antlr.psi.JassVar
import io.github.warraft.language.jass.antlr.psi.JassVarScope
import io.github.warraft.language.jass.antlr.state.ext.lsp4j.completionExt
import io.github.warraft.language.jass.antlr.state.ext.lsp4j.definitionExt
import io.github.warraft.language.jass.antlr.state.ext.lsp4j.documentHighlightExt
import io.github.warraft.language.jass.antlr.state.ext.lsp4j.formatting.formattingEx
import io.github.warraft.language.jass.antlr.state.ext.lsp4j.hoverExt
import io.github.warraft.language.jass.antlr.state.ext.lsp4j.referencesExt
import io.github.warraft.language.jass.antlr.state.ext.lsp4j.signatureHelpExt
import org.antlr.v4.runtime.*
import org.eclipse.lsp4j.*

class JassState : LanguageState() {
    val states: MutableList<JassState> = mutableListOf()

    val typeScope = JassTypeScope(this)
    val varScope = JassVarScope(this)
    val funScope = JassFunScope(this)

    override fun completion() = completionExt()
    override fun hover(params: HoverParams?): Hover? = hoverExt(params)
    override fun signatureHelp(params: SignatureHelpParams?): SignatureHelp? = signatureHelpExt(params)
    override fun definition(params: DefinitionParams?): MutableList<LocationLink> = definitionExt(params)
    override fun documentHighlight(params: DocumentHighlightParams?): List<DocumentHighlight> = documentHighlightExt(params)
    override fun references(params: ReferenceParams?): MutableList<out Location?> = referencesExt(params)
    override fun formatting(params: DocumentFormattingParams?): List<TextEdit> = formattingEx(params)

    override fun lexer(stream: CharStream): Lexer = JassLexer(stream)
    override fun parser(stream: CommonTokenStream): Parser = JassParser(stream)

    override fun parse(stream: CharStream, states: List<LanguageState>, version: Int?) {
        if (!needParse(version)) return

        this.states.clear()
        for (s in states) {
            if (s is JassState) this.states.add(s)
        }

        typeScope.clear()
        varScope.clear()
        funScope.clear()

        super.parse(stream, states, version)

        rootCtx = (parser as JassParser).root().also {
            it.children.forEach {
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

                    is TypeContext -> JassType.parse(it, this)
                    is NativeRuleContext -> JassFun.parse(it, null, this)
                    is FunctionContext -> JassFun.parse(it, null, this)
                }
            }
        }

        for (c in tokenFactory.commentList) {
            if (!tokenFactory.commentMap.containsKey(c.line)) continue
            semanticHub.add(c, SemanticTokenType.COMMENT)
        }

        diagnosticHub.diagnostics.addAll(errorListener.diagnostics)
    }
}
