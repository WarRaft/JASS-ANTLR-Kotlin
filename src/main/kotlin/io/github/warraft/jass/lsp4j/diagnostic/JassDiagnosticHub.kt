package io.github.warraft.jass.lsp4j.diagnostic

import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.TerminalNode
import org.eclipse.lsp4j.Diagnostic
import org.eclipse.lsp4j.DiagnosticSeverity
import org.eclipse.lsp4j.Position
import org.eclipse.lsp4j.Range

class JassDiagnosticHub {
    val diagnostics = mutableListOf<Diagnostic>()

    fun add(

        code: JassDiagnosticCode,
        msg: String,
    ) {
        diagnostics.add(
            Diagnostic(
                Range(
                    Position(0, 0),
                    Position(0, 0),
                ),
                msg,
                DiagnosticSeverity.Error,
                SOURCE,
                code.name
            )
        )
    }


    fun add(
        node: ParserRuleContext?,
        code: JassDiagnosticCode,
        msg: String,
    ) {
        diagnostics.add(
            Diagnostic(
                when (node) {
                    null -> Range(
                        Position(0, 0),
                        Position(0, 0),
                    )

                    else -> Range(
                        Position(node.start.line - 1, node.start.charPositionInLine),
                        Position(
                            node.stop.line - 1,
                            node.stop.charPositionInLine + (node.stop.stopIndex - node.stop.stopIndex) + 1
                        ),
                    )
                },
                msg,
                DiagnosticSeverity.Error,
                SOURCE,
                code.name
            )
        )
    }


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
                        Position(s.line - 1, s.charPositionInLine),
                        Position(s.line - 1, s.charPositionInLine + (s.stopIndex - s.stopIndex) + 1),
                    )
                },
                msg,
                DiagnosticSeverity.Error,
                SOURCE,
                code.name
            )
        )
    }

    fun clear() {
        diagnostics.clear()
    }

    companion object {
        private const val SOURCE = "JASS"
    }
}
