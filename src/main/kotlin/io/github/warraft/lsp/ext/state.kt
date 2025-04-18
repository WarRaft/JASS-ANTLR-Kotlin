package io.github.warraft.lsp.ext

import io.github.warraft.language._.state.LanguageState
import io.github.warraft.language.`as`.state.AsState
import io.github.warraft.language.bni.state.BniState
import io.github.warraft.language.jass.state.JassState
import io.github.warraft.language.slk.SlkState
import io.github.warraft.language.vex.state.VjassState
import io.github.warraft.language.vex.state.ZincState
import io.github.warraft.language.wts.state.WtsState
import io.github.warraft.lsp.LanguageServer
import org.antlr.v4.runtime.CharStreams
import java.nio.file.Path
import kotlin.io.path.extension

fun LanguageServer.stateGet(p: Path): LanguageState? {
    var state = stateMap[p]
    var lng = languageMap[p] ?: when (p.extension) {
        "as" -> "angelscript"
        "j" -> "jass"
        "vj" -> "vjass"
        "zn" -> "zinc"
        "wts" -> "wts"
        "bni" -> "bni"
        "slk" -> "slk"
        else -> null
    }
    when (lng) {
        "angelscript" -> if (state !is AsState) state = AsState()
        "jass" -> if (state !is JassState) state = JassState()
        "vjass" -> if (state !is VjassState) state = VjassState()
        "zinc" -> if (state !is ZincState) state = ZincState()
        "wts" -> if (state !is WtsState) state = WtsState()
        "bni" -> if (state !is BniState) state = BniState()
        "slk" -> if (state !is SlkState) state = SlkState()
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
