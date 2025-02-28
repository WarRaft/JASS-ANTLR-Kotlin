package io.github.warraft.language.jass.antlr.state.ext.lsp

import io.github.warraft.language.jass.antlr.state.JassState
import org.eclipse.lsp4j.ParameterInformation
import org.eclipse.lsp4j.SignatureHelp
import org.eclipse.lsp4j.SignatureHelpParams
import org.eclipse.lsp4j.SignatureInformation

fun JassState.signatureHelpExt(params: SignatureHelpParams?): SignatureHelp? {
    //val position = params?.position ?: return null
    return SignatureHelp(
        listOf(
            SignatureInformation(
                "label",
                "documentation",
                listOf(
                    ParameterInformation("plabel1", "pdocumentation1"),
                    ParameterInformation("plabel2", "pdocumentation1")
                )
            )
        ),
        0,
        0
    )
}
