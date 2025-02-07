package io.github.warraft.vex.antlr.state

import io.github.warraft.languages.antlr.state.LanguageState
import org.antlr.v4.runtime.CharStream

open class VexState : LanguageState() {
    override fun nodeCount(): Int = 0

    override fun parse(stream: CharStream, states: List<LanguageState>) {
        super.parse(stream, states)
    }
}
