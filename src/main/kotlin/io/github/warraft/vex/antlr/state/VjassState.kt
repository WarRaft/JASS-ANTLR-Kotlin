package io.github.warraft.vex.antlr.state

import io.github.warraft.JassLexer
import io.github.warraft.VjassParser
import io.github.warraft.jass.antlr.utils.JassErrorListener
import io.github.warraft.languages.lsp4j.antlr.state.LanguageState
import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CommonTokenStream

class VjassState : VexState() {

    override fun parse(stream: CharStream, states: List<LanguageState>) {
        super.parse(stream, states)
        val errorJassErrorListener = JassErrorListener()
        val lexer = JassLexer(stream)
        lexer.removeErrorListeners()
        lexer.addErrorListener(errorJassErrorListener)

        val tokens = CommonTokenStream(lexer)

        val parser = VjassParser(tokens)
        parser.removeErrorListeners()
        parser.addErrorListener(errorJassErrorListener)
        //root(parser.root())
    }

}
