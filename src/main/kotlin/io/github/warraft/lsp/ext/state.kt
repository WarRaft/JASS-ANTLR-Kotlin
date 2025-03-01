@file:Suppress("DuplicatedCode")

package io.github.warraft.lsp.ext

import io.github.warraft.language._.antlr.state.LanguageState
import io.github.warraft.language.jass.antlr.state.JassState
import io.github.warraft.language.vex.antlr.state.VjassState
import io.github.warraft.language.vex.antlr.state.ZincState
import io.github.warraft.lsp.LanguageServer
import org.antlr.v4.runtime.CharStreams
import java.nio.file.Path
import kotlin.io.path.extension

fun LanguageServer.stateGet(p: Path): LanguageState? {
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
        it.server = this
    }
    return state
}

fun LanguageServer.stateUpdate(path: Path, text: String, version: Int?) {
    val s = stateGet(path)
    if (s == null) return
    val sdk = mutableListOf<LanguageState>()
    for (state in sdkStateList) {
        if (s.path == state.path) break
        sdk.add(state)
    }
    s.parse(CharStreams.fromString(text), sdk, version)
}
