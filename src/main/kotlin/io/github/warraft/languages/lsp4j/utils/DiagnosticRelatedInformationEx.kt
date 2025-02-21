package io.github.warraft.languages.lsp4j.utils

import io.github.warraft.jass.antlr.psi.JassVar
import org.eclipse.lsp4j.DiagnosticRelatedInformation
import org.eclipse.lsp4j.Location

class DiagnosticRelatedInformationEx : DiagnosticRelatedInformation() {

    companion object {
        fun get(v: JassVar, s: String): DiagnosticRelatedInformation = DiagnosticRelatedInformation(Location(v.state.path?.toUri().toString(), RangeEx.get(v.symbol)), s)
    }
}
