package io.github.warraft.jass.antlr.state.ext.lsp4j

import io.github.warraft.jass.antlr.state.JassState
import io.github.warraft.languages.lsp4j.LanguageServerEx
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
