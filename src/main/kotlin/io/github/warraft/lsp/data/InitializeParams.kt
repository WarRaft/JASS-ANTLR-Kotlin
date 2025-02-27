package io.github.warraft.lsp.data

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#initializeParams

@Serializable
data class InitializeParams(
    val processId: Int? = null,
    val locale: String? = null,
    val initializationOptions: JsonElement?,
) {

    /*
    clientInfo?:
    {
        name: string;
        version ?: string;
    };
    capabilities: ClientCapabilities;
    trace?: TraceValue;
    workspaceFolders?: WorkspaceFolder[] | null;
     */

    companion object {
        const val METHOD = "initialize"
    }
}
