package io.github.warraft.jass.lsp4j.diagnostic

import org.antlr.v4.runtime.tree.TerminalNode
import org.eclipse.lsp4j.Diagnostic
import org.eclipse.lsp4j.DiagnosticSeverity
import org.eclipse.lsp4j.Position
import org.eclipse.lsp4j.Range

class JassDiagnosticHub {
    val diagnostics = mutableListOf<Diagnostic>()

    fun add(
        node: TerminalNode?,
        code: JassDiagnosticCode,
        msg: String,
    ) {
        val s = node?.symbol
        diagnostics.add(
            Diagnostic(
                when (s) {
                    null -> Range(
                        Position(0, 0),
                        Position(0, 0),
                    )

                    else -> Range(
                        Position(s.line - 1, s.startIndex),
                        Position(s.line - 1, s.stopIndex),
                    )
                },
                msg,
                DiagnosticSeverity.Error,
                "JASS",
                code.name
            )
        )

    }

    fun clear() {
        diagnostics.clear()
    }
}
