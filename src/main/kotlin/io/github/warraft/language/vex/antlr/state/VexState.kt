package io.github.warraft.language.vex.antlr.state

import io.github.warraft.language._.antlr.state.LanguageState
import org.antlr.v4.runtime.CharStream

abstract class VexState : LanguageState() {

    override fun parse(stream: CharStream, states: List<LanguageState>, version: Int?) {
        super.parse(stream, states, version)
    }
}
