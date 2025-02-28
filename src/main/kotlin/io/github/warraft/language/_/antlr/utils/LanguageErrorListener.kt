package io.github.warraft.language._.antlr.utils

import io.github.warraft.language.jass.lsp.diagnostic.JassDiagnosticCode
import io.github.warraft.lsp.data.Diagnostic
import io.github.warraft.lsp.data.DiagnosticSeverity
import io.github.warraft.lsp.data.Position
import io.github.warraft.lsp.data.Range
import org.antlr.v4.runtime.BaseErrorListener
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.RecognitionException
import org.antlr.v4.runtime.Recognizer
import org.antlr.v4.runtime.atn.ATNConfigSet
import org.antlr.v4.runtime.dfa.DFA
import java.util.*

class LanguageErrorListener() : BaseErrorListener() {
    val diagnostics = mutableListOf<Diagnostic>()

    override fun syntaxError(
        recognizer: Recognizer<*, *>?,
        offendingSymbol: Any?,
        line: Int,
        charPositionInLine: Int,
        msg: String?,
        e: RecognitionException?,
    ) {
        val l = (line - 1).toUInt()
        val ch = charPositionInLine.toUInt()
        diagnostics.add(

            Diagnostic(
                range = Range(
                    Position(l, ch),
                    Position(l, ch + 1u)
                ),
                severity = DiagnosticSeverity.Error,
                code = JassDiagnosticCode.SYNTAX.name,
                message = msg ?: "Uknown error",
            )
        )
    }

    override fun reportAmbiguity(
        recognizer: Parser?,
        dfa: DFA?,
        startIndex: Int,
        stopIndex: Int,
        exact: Boolean,
        ambigAlts: BitSet?,
        configs: ATNConfigSet?,
    ) {
    }

    override fun reportAttemptingFullContext(
        recognizer: Parser?,
        dfa: DFA?,
        startIndex: Int,
        stopIndex: Int,
        conflictingAlts: BitSet?,
        configs: ATNConfigSet?,
    ) {
    }

    override fun reportContextSensitivity(
        recognizer: Parser?,
        dfa: DFA?,
        startIndex: Int,
        stopIndex: Int,
        prediction: Int,
        configs: ATNConfigSet?,
    ) {
    }

    fun clear() {
        diagnostics.clear()
    }
}
