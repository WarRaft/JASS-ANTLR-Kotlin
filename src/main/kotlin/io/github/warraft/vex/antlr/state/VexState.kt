package io.github.warraft.vex.antlr.state

import io.github.warraft.languages.antlr.state.LanguageState
import org.antlr.v4.runtime.CharStream

open class VexState : LanguageState() {

    override fun parse(stream: CharStream, states: List<LanguageState>, version: Int?) {
        super.parse(stream, states, version)
    }
}
