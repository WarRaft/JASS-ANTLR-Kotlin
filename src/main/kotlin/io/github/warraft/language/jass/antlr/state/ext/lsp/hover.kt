package io.github.warraft.language.jass.antlr.state.ext.lsp

import io.github.warraft.language.jass.antlr.psi.JassFun
import io.github.warraft.language.jass.antlr.psi.JassTypeName.Companion.NOTHING
import io.github.warraft.language.jass.antlr.state.JassState
import io.github.warraft.lsp.data.Hover
import io.github.warraft.lsp.data.MarkupContent
import io.github.warraft.lsp.data.MarkupKind
import io.github.warraft.lsp.data.Position

fun JassState.hoverExt(position: Position?): Hover? {
    val node = tokenTree.find(position) ?: return null
    val b = StringBuilder()
    val n = "  \n"
    when (node) {
        is JassFun -> {
            var f: JassFun? = null
            for (s in states + this) {
                f = s.funScope.definition(node)
                if (f != null) break
            }
            if (f == null) return null

            if (f.comments.isNotEmpty()) {
                b.append(f.comments.toString()).append("\n")
            }

            if (f.native) b.append("**native**")
            else b.append("**function**")
            b.append(" `${f.name}`$n**takes**:$n")
            if (f.param.isEmpty()) b.append("- *nothing*$n")
            else for (p in f.param) b.append("- `${p.type?.name}` ${p.name}$n")

            val type = f.type
            if (type == null) {
                b.append("$n**returns** is undefined$n")
            } else {
                b.append("$n**returns**:$n")
                if (type.name == NOTHING) b.append("- *nothing*$n")
                else b.append("- `${type.name}`$n")
            }
        }
    }

    if (b.isEmpty()) return null
    return Hover(MarkupContent(MarkupKind.Markdown, b.toString()))
}
