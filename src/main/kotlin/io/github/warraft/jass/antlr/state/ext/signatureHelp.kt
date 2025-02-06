package io.github.warraft.jass.antlr.state.ext

import io.github.warraft.jass.antlr.state.JassState
import io.github.warraft.jass.lsp4j.JassLanguageServer
import org.eclipse.lsp4j.ParameterInformation
import org.eclipse.lsp4j.SignatureHelp
import org.eclipse.lsp4j.SignatureHelpParams
import org.eclipse.lsp4j.SignatureInformation

fun JassState.signatureHelp(server: JassLanguageServer, params: SignatureHelpParams?): SignatureHelp? {
    val position = params?.position ?: return null
    server.log("signature: $position")
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
