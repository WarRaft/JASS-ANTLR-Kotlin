package io.github.warraft.language.jass.lsp.diagnostic

import io.github.warraft.lsp.data.Diagnostic
import io.github.warraft.lsp.data.DiagnosticRelatedInformation
import io.github.warraft.lsp.data.DiagnosticSeverity
import io.github.warraft.lsp.data.Position
import io.github.warraft.lsp.data.Range
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.TerminalNode

class JassDiagnosticHub {
    val diagnostics = mutableListOf<Diagnostic>()

    fun add(diagnostic: Diagnostic) {
        diagnostics.add(diagnostic)
    }

    fun add(
        code: JassDiagnosticCode,
        msg: String,
        related: MutableList<DiagnosticRelatedInformation> = mutableListOf(),
    ) = add(Range(Position(0u, 0u), Position(0u, 0u)), code, msg, related)

    fun add(
        node: ParserRuleContext?,
        code: JassDiagnosticCode,
        msg: String,
        related: MutableList<DiagnosticRelatedInformation> = mutableListOf(),
    ) = add(Range.of(node), code, msg, related)

    fun add(
        node: TerminalNode?,
        code: JassDiagnosticCode,
        msg: String,
        related: MutableList<DiagnosticRelatedInformation> = mutableListOf(),
    ) = add(Range.of(node), code, msg, related)

    fun add(
        range: Range?,
        code: JassDiagnosticCode,
        msg: String,
        related: MutableList<DiagnosticRelatedInformation> = mutableListOf(),
    ) {
        if (range == null) return
        diagnostics.add(
            Diagnostic(
                range = range,
                severity = DiagnosticSeverity.Error,
                code = code.name,
                message = msg,
                relatedInformation = related
            )
        )
    }

    fun clear() {
        diagnostics.clear()
    }
}
