package io.github.warraft.language.jass.state

import io.github.warraft.JassLexer
import io.github.warraft.JassParser
import io.github.warraft.JassParser.*
import io.github.warraft.language._.state.LanguageState
import io.github.warraft.language.jass.psi.*
import io.github.warraft.language.jass.state.ext.lsp.*
import io.github.warraft.language.jass.state.ext.lsp.formatting.formattingEx
import io.github.warraft.lsp.data.*
import io.github.warraft.lsp.data.semantic.SemanticTokenType
import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.Lexer
import org.antlr.v4.runtime.Parser

class JassState : LanguageState() {
    val states: MutableList<JassState> = mutableListOf()

    val typeScope = JassTypeScope(this)
    val varScope = JassVarScope(this)
    val funScope = JassFunScope(this)

    override fun completion(): CompletionList? = completionExt()
    override fun hover(position: Position): Hover? = hoverExt(position)
    override fun documentHighlight(position: Position): List<DocumentHighlight>? = documentHighlightExt(position)
    override fun definition(position: Position): List<LocationLink>? = definitionExt(position)
    override fun references(position: Position): List<Location>? = referencesExt(position)
    override fun formatting(): List<TextEdit>? = formattingEx()
    override fun rename(params: RenameParams): WorkspaceEdit? = renameEx(params)


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

                        FoldingRange.of(globalsCtx, endglobalsCtx)?.also {
                            it.kind = FoldingRangeKind.Region
                            foldingRange.add(it)
                        }

                        semanticHub
                            .add(globalsCtx, SemanticTokenType.KEYWORD)
                            .add(endglobalsCtx, SemanticTokenType.KEYWORD)

                        for (ctx in it.variable()) JassVar.parse(ctx, null, this)
                    }

                    is TypeContext -> JassType.definition(it, this)
                    is NativeRuleContext -> JassFun.parse(it, null, this)
                    is FunctionContext -> JassFun.parse(it, null, this)
                }
            }
        }

        for (c in tokenFactory.commentList) {
            if (!tokenFactory.commentMap.containsKey(c.line)) continue
            semanticHub.add(c, SemanticTokenType.COMMENT)
        }
    }
}
