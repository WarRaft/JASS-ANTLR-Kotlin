package io.github.warraft.lsp.data

import io.github.warraft.language.jass.antlr.psi.base.JassNodeBase
import io.github.warraft.language.jass.antlr.state.JassState
import kotlinx.serialization.Serializable
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.Token

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#location

@Serializable
class Location(
    val uri: String,
    val range: Range,
) {
    companion object {
        fun of(state: JassState?, range: Range?): Location? {
            if (state == null || range == null) return null
            return Location(uri = state.path?.toUri().toString(), range = range)
        }
        fun of(node: JassNodeBase?, ctx: ParserRuleContext?): Location? = of(node?.state, Range.of(ctx))
        fun of(node: JassNodeBase?, token: Token?): Location? = of(node?.state, Range.of(token))
    }
}

