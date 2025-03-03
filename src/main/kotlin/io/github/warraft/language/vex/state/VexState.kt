package io.github.warraft.language.vex.state

import io.github.warraft.language._.state.LanguageState
import org.antlr.v4.runtime.CharStream

abstract class VexState : LanguageState() {
    override fun parse(stream: CharStream, states: List<LanguageState>, version: Int?) {
        super.parse(stream, states, version)
    }
}
