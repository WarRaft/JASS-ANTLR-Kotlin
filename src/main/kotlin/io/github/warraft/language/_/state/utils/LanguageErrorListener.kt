package io.github.warraft.language._.state.utils

import io.github.warraft.language._.state.LanguageState
import io.github.warraft.lsp.data.Diagnostic
import io.github.warraft.lsp.data.DiagnosticCode
import io.github.warraft.lsp.data.DiagnosticSeverity
import io.github.warraft.lsp.data.Position
import io.github.warraft.lsp.data.Range
import org.antlr.v4.runtime.BaseErrorListener
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.RecognitionException
import org.antlr.v4.runtime.Recognizer
import org.antlr.v4.runtime.atn.ATNConfigSet
import org.antlr.v4.runtime.dfa.DFA
import java.util.BitSet

class LanguageErrorListener(val parent: LanguageState) : BaseErrorListener() {
    override fun syntaxError(
        recognizer: Recognizer<*, *>?,
        offendingSymbol: Any?,
        line: Int,
        charPositionInLine: Int,
        msg: String?,
        e: RecognitionException?,
    ) {
        val l = (line - 1)
        val ch = charPositionInLine
        parent.diagnostic.add(
            Diagnostic(
                range = Range.of(l, ch, l, ch + 1),
                severity = DiagnosticSeverity.Error,
                code = DiagnosticCode.SYNTAX,
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
}
