package io.github.warraft.language.jass.state.ext.lsp

import io.github.warraft.language.jass.psi.JassFun
import io.github.warraft.language.jass.psi.JassType
import io.github.warraft.language.jass.psi.JassVar
import io.github.warraft.language.jass.psi.base.JassNodeBase
import io.github.warraft.language.jass.state.JassState
import io.github.warraft.lsp.data.Range
import io.github.warraft.lsp.data.RenameParams
import io.github.warraft.lsp.data.TextEdit
import io.github.warraft.lsp.data.WorkspaceEdit

fun JassState.renameEx(params: RenameParams): WorkspaceEdit? {
    val node = tokenTree.find(params.position) ?: return null

    val edits = mutableListOf<TextEdit>()

    fun base(list: List<JassNodeBase>) {
        for (v in list) {
            if (path != v.state.path) continue
            val r = Range.of(v.symbol) ?: continue
            edits.add(
                TextEdit(
                    range = r,
                    newText = params.newName
                )
            )
        }
    }

    when (node) {
        is JassType -> base(typeScope.usages(node))
        is JassVar -> base(node.scope.usages(node))
        is JassFun -> base(node.scope.usages(node))
    }

    val uri = path?.toUri().toString()
    return if (edits.isEmpty()) null else WorkspaceEdit(
        changes = mutableMapOf(
            uri to edits,
        )
    )
}
