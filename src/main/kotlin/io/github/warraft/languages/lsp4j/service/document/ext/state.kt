package io.github.warraft.languages.lsp4j.service.document.ext

import io.github.warraft.jass.antlr.state.JassState
import io.github.warraft.languages.antlr.state.LanguageState
import io.github.warraft.languages.lsp4j.service.document.TextDocumentServiceEx
import io.github.warraft.vex.antlr.state.VjassState
import io.github.warraft.vex.antlr.state.ZincState
import org.antlr.v4.runtime.CharStreams
import org.eclipse.lsp4j.*
import java.net.URI
import java.nio.file.Path
import kotlin.io.path.extension
import kotlin.io.path.toPath

fun TextDocumentServiceEx.stateGet(params: TextDocumentPositionAndWorkDoneProgressAndPartialResultParams?): LanguageState? = stateGet(params?.textDocument)
fun TextDocumentServiceEx.stateGet(params: TextDocumentPositionAndWorkDoneProgressParams?): LanguageState? = stateGet(params?.textDocument)
fun TextDocumentServiceEx.stateGet(params: DocumentFormattingParams?): LanguageState? = stateGet(params?.textDocument)
fun TextDocumentServiceEx.stateGet(params: SemanticTokensParams?): LanguageState? = stateGet(params?.textDocument)
fun TextDocumentServiceEx.stateGet(params: FoldingRangeRequestParams?): LanguageState? = stateGet(params?.textDocument)
fun TextDocumentServiceEx.stateGet(params: DocumentDiagnosticParams?): LanguageState? = stateGet(params?.textDocument)
fun TextDocumentServiceEx.stateGet(params: DocumentSymbolParams?): LanguageState? = stateGet(params?.textDocument)
fun TextDocumentServiceEx.stateGet(textDocument: TextDocumentIdentifier?): LanguageState? = stateGet(textDocument?.uri)
fun TextDocumentServiceEx.stateGet(uri: String?): LanguageState? = if (uri == null) null else stateGet(URI(uri).toPath())

fun TextDocumentServiceEx.stateGet(p: Path): LanguageState? {
    var state = stateMap[p]
    var lng = languageMap[p] ?: when (p.extension) {
        "j" -> "jass"
        "vj" -> "vjass"
        "zn" -> "zinc"
        else -> null
    }
    when (lng) {
        "jass" -> if (state !is JassState) state = JassState()
        "vjass" -> if (state !is VjassState) state = VjassState()
        "zinc" -> if (state !is ZincState) state = ZincState()
    }

    if (state == null) return null

    stateMap[p] = state.also {
        it.path = p
        it.server = server
    }
    return state
}

fun TextDocumentServiceEx.stateUpdate(path: Path, text: String, version: Int) {
    val s = stateGet(path)
    if (s == null) return
    val sdk = mutableListOf<LanguageState>()
    for (state in sdkStateList) {
        if (s.path == state.path) break
        sdk.add(state)
    }
    s.parse(CharStreams.fromString(text), sdk, version)
}

