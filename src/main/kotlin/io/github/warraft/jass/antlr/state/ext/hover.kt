package io.github.warraft.jass.antlr.state.ext

import io.github.warraft.jass.antlr.psi.JassFun
import io.github.warraft.jass.antlr.state.JassState
import org.eclipse.lsp4j.Hover
import org.eclipse.lsp4j.HoverParams
import org.eclipse.lsp4j.MarkupContent
import org.eclipse.lsp4j.MarkupKind

fun JassState.hover(params: HoverParams?): Hover? {
    val pos = params?.position ?: return null
    val node = tokenTree.find(pos) ?: return null
    var s = ""
    if (node is JassFun) {
        if (node.native) {
            s = """
            [native](https://warraft.github.io/JASS-doc/native.html) **${node.name}**   
            """.trimIndent()
        }
    }

    if (s.isEmpty()) return null
    return Hover(MarkupContent(MarkupKind.MARKDOWN, s))
}
