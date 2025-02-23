package io.github.warraft.languages.antlr.utils

import io.github.warraft.jass.lsp4j.diagnostic.JassDiagnosticCode
import org.antlr.v4.runtime.BaseErrorListener
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.RecognitionException
import org.antlr.v4.runtime.Recognizer
import org.antlr.v4.runtime.atn.ATNConfigSet
import org.antlr.v4.runtime.dfa.DFA
import org.eclipse.lsp4j.Diagnostic
import org.eclipse.lsp4j.DiagnosticSeverity
import org.eclipse.lsp4j.Position
import org.eclipse.lsp4j.Range
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
        diagnostics.add(
            Diagnostic(
                Range(Position(line - 1, charPositionInLine), Position(line - 1, charPositionInLine + 1)),
                msg ?: "Uknown error",
                DiagnosticSeverity.Error,
                "",
                JassDiagnosticCode.SYNTAX.name
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

    fun clear(){
        diagnostics.clear()
    }
}
