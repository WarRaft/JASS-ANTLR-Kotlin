package io.github.warraft.languages.lsp4j.utils

import io.github.warraft.jass.antlr.psi.JassFun
import io.github.warraft.jass.antlr.psi.JassType
import io.github.warraft.jass.antlr.psi.JassVar
import io.github.warraft.jass.antlr.state.JassState
import org.antlr.v4.runtime.Token
import org.eclipse.lsp4j.DiagnosticRelatedInformation
import org.eclipse.lsp4j.Location

class DiagnosticRelatedInformationEx : DiagnosticRelatedInformation() {
    companion object {
        fun get(t: JassType, s: String): DiagnosticRelatedInformation = get(t.state, t.symbol, s)
        fun get(v: JassVar, s: String): DiagnosticRelatedInformation = get(v.state, v.symbol, s)
        fun get(f: JassFun, s: String): DiagnosticRelatedInformation = get(f.state, f.symbol, s)
        fun get(state: JassState?, t: Token?, s: String): DiagnosticRelatedInformation = DiagnosticRelatedInformation(Location(state?.path?.toUri().toString(), RangeEx.get(t)), s)
    }
}
