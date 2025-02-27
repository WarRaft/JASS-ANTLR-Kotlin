package io.github.warraft.language.jass.antlr.state.ext.lsp4j

import io.github.warraft.language.jass.antlr.psi.JassFun
import io.github.warraft.language.jass.antlr.state.JassState
import org.eclipse.lsp4j.Hover
import org.eclipse.lsp4j.HoverParams
import org.eclipse.lsp4j.MarkupContent
import org.eclipse.lsp4j.MarkupKind

fun JassState.hoverExt(params: HoverParams?): Hover? {
    val pos = params?.position ?: return null
    val node = tokenTree.find(pos) ?: return null
    val b = StringBuilder()

    // https://warraft.github.io/JASS-doc/function.html

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
            b.append(" `${f.name}`  \n**takes**:  \n")
            if (f.param.isEmpty()) b.append("- *nothing*  \n")
            else for (p in f.param) b.append("- `${p.type?.name}` ${p.name}  \n")
            b.append("  \n**returns**:  \n")
            //if (f.type is JassUndefinedType) b.append("- *nothing*  \n")
            //else b.append("- `${f.type?.name}`  \n")
        }
    }

    if (b.isEmpty()) return null
    return Hover(MarkupContent(MarkupKind.MARKDOWN, b.toString()))
}
