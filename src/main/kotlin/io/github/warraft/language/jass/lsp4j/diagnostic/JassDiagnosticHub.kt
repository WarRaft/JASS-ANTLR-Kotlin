package io.github.warraft.language.jass.lsp4j.diagnostic

import io.github.warraft.language._.lsp4j.utils.RangeEx
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.TerminalNode
import org.eclipse.lsp4j.Diagnostic
import org.eclipse.lsp4j.DiagnosticRelatedInformation
import org.eclipse.lsp4j.DiagnosticSeverity
import org.eclipse.lsp4j.Position
import org.eclipse.lsp4j.Range

class JassDiagnosticHub {
    val diagnostics = mutableListOf<Diagnostic>()

    fun add(
        code: JassDiagnosticCode,
        msg: String,
        related: List<DiagnosticRelatedInformation> = emptyList(),
    ) = add(Range(Position(0, 0), Position(0, 0)), code, msg, related)

    fun add(
        node: ParserRuleContext?,
        code: JassDiagnosticCode,
        msg: String,
        related: List<DiagnosticRelatedInformation> = emptyList(),
    ) = add(RangeEx.get(node), code, msg, related)

    fun add(
        node: TerminalNode?,
        code: JassDiagnosticCode,
        msg: String,
        related: List<DiagnosticRelatedInformation> = emptyList(),
    ) = add(RangeEx.get(node), code, msg, related)

    fun add(
        range: Range,
        code: JassDiagnosticCode,
        msg: String,
        related: List<DiagnosticRelatedInformation> = emptyList(),
    ) {
        diagnostics.add(
            Diagnostic(
                range,
                msg,
                DiagnosticSeverity.Error,
                SOURCE,
                code.name
            ).apply {
                relatedInformation = related
            }
        )
    }

    fun clear() {
        diagnostics.clear()
    }

    companion object {
        private const val SOURCE = "JASS"
    }
}
