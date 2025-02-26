package io.github.warraft.languages.lsp4j.service

import com.google.gson.JsonObject
import com.google.gson.JsonPrimitive
import io.github.warraft.languages.lsp4j.LanguageServerEx
import io.github.warraft.languages.lsp4j.service.document.ext.didChangeSDK
import org.eclipse.lsp4j.DidChangeConfigurationParams
import org.eclipse.lsp4j.DidChangeWatchedFilesParams
import org.eclipse.lsp4j.services.WorkspaceService
import java.nio.file.Path

class WorkspaceServiceEx(val server: LanguageServerEx) : WorkspaceService {

    fun didChangeSDK(json: JsonObject?) {
        if (json == null) return
        val wc = json.getAsJsonObject("Warcraft")
        if (wc == null) return
        val scripts = wc.getAsJsonArray("scripts")

        val list: MutableList<Path> = mutableListOf()

        for (script in scripts) {
            if (script !is JsonPrimitive) continue
            if (!script.isString) continue
            list.add(Path.of(script.asJsonPrimitive.asString))
        }

        //server.textDocumentService.didChangeSDK(list)
    }

    override fun didChangeConfiguration(params: DidChangeConfigurationParams) {
        didChangeSDK(params.settings as? JsonObject)
    }

    override fun didChangeWatchedFiles(params: DidChangeWatchedFilesParams) {
    }
}
