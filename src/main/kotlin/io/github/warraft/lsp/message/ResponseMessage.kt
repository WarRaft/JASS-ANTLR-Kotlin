package io.github.warraft.lsp.message

import io.github.warraft.lsp.utils.Params
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#responseMessage

@Serializable
class ResponseMessage(
    val method: String,
    val params: @Contextual Params,
    //id: integer | string | null;
    //result?: LSPAny;
    //error?: ResponseError;
) : Message()
