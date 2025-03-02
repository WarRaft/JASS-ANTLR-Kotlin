package io.github.warraft.lsp.data

import io.github.warraft.language.jass.antlr.psi.base.JassNodeBase
import kotlinx.serialization.Serializable

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#location

@Serializable
class Location(
    val uri: String,
    val range: Range,
) {
    companion object {
        fun of(node: JassNodeBase?): Location? {
            if (node == null) return null
            val r = Range.of(node.definition) ?: return null
            val uri = node.state.path?.toUri().toString()
            return Location(
                uri = uri,
                range = r
            )
        }
    }
}

