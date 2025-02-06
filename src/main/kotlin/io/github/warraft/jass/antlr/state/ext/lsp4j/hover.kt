package io.github.warraft.jass.antlr.state.ext.lsp4j

import io.github.warraft.jass.antlr.psi.JassFun
import io.github.warraft.jass.antlr.psi.JassUndefinedType
import io.github.warraft.jass.antlr.state.JassState
import org.eclipse.lsp4j.Hover
import org.eclipse.lsp4j.HoverParams
import org.eclipse.lsp4j.MarkupContent
import org.eclipse.lsp4j.MarkupKind

fun JassState.hoverExt(params: HoverParams?): Hover? {
    val pos = params?.position ?: return null
    val node = tokenTree.find(pos) ?: return null
    val b = StringBuilder()

    // https://warraft.github.io/JASS-doc/function.html

    val uri = "https://warraft.github.io/JASS-doc"

    if (node is JassFun) {
        val f = node.root

        if (f.comments.isNotEmpty()) {
            b.append(f.comments.toString()).append("\n")
        }

        if (f.native) {
            b.append("[native]($uri/native.html)")
        } else {
            b.append("[function]($uri/native.html)")
        }
        b.append(" **${node.name}** _takes_ ")
        if (f.param.isEmpty()) {
            b.append(" **nothing** ")
        } else {
            val list = mutableListOf<String>()
            for (p in f.param) {
                list.add("**${p.type.name}** ${p.name}")
            }
            b.append(list.joinToString(", "))
        }
        b.append(" _returns_ ")
        if (f.type is JassUndefinedType) {
            b.append("**nothing**")
        } else {
            b.append("**${f.type.name}**")
        }

    }

    if (b.isEmpty()) return null
    return Hover(MarkupContent(MarkupKind.MARKDOWN, b.toString()))
}
