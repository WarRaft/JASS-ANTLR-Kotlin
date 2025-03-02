package io.github.warraft.lsp.ext

import io.github.warraft.lsp.LanguageServer
import io.github.warraft.lsp.data.DidChangeConfigurationParams
import io.github.warraft.lsp.data.Message
import io.github.warraft.lsp.data.MessageLogType
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import org.antlr.v4.runtime.CharStreams
import java.nio.file.Path
import kotlin.io.path.isReadable

fun LanguageServer.didChangeSDK(element: JsonElement?) {
    if (element == null) return
    val wc = (element.jsonObject["settings"] ?: element).jsonObject["Warcraft"] ?: return
    val scripts = wc.jsonObject["scripts"]?.jsonArray ?: return

    sdkStateList.clear()
    for (script in scripts) {
        if (script !is JsonPrimitive) continue
        if (!script.isString) continue
        val path = Path.of(script.jsonPrimitive.content)
        if (!path.isReadable()) {
            log(path.toAbsolutePath().toString(), MessageLogType.Error)
            show(path.toAbsolutePath().toString(), MessageLogType.Error)
            continue
        }
        val s = stateGet(path) ?: continue
        sdkStateList.add(s.also {
            it.path = path
            it.path = path
            it.server = this
            it.parse(CharStreams.fromPath(path), sdkStateList, 1)
        })
    }
}

fun LanguageServer.didChangeConfiguration(message: Message) {
    val params = message.params ?: return
    val p = json.decodeFromJsonElement<DidChangeConfigurationParams>(DidChangeConfigurationParams.serializer(), params)
    didChangeSDK(p.settings)
}

