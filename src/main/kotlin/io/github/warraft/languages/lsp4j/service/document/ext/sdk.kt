package io.github.warraft.languages.lsp4j.service.document.ext

import io.github.warraft.languages.lsp4j.service.document.TextDocumentServiceEx
import org.antlr.v4.runtime.CharStreams
import java.nio.file.Path
import kotlin.io.path.isReadable

fun TextDocumentServiceEx.didChangeSDK(paths: List<Path>) {
    sdkStateList.clear()
    for (path in paths) {
        if (!path.isReadable()) continue
        sdkStateList.add(stateGet(path).also {
            it.path = path
            it.path = path
            it.server = server
            it.parse(CharStreams.fromPath(path), sdkStateList, 1)
        })
    }
}
