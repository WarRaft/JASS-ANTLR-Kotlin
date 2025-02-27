package io.github.warraft.lsp

import io.github.warraft.lsp.message.RequestMessage
import io.github.warraft.lsp.message.ResponseMessage
import io.github.warraft.lsp.method.initialize.InitializeParams
import io.github.warraft.lsp.method.window.MessageType
import io.github.warraft.lsp.method.window.logMessage.LogMessageParams
import io.github.warraft.lsp.method.window.showMessage.ShowMessageParams
import io.github.warraft.lsp.serializer.IntOrString
import io.github.warraft.lsp.serializer.IntOrString.IntVal
import io.github.warraft.lsp.utils.Params
import kotlinx.serialization.Contextual
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#headerPart
class LanguageServer {
    private val reader = BufferedReader(InputStreamReader(System.`in`))
    private val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    @OptIn(ExperimentalSerializationApi::class)
    val json = Json {
        classDiscriminator = "AnalClassDiscriminator"
        ignoreUnknownKeys = true
        prettyPrint = true
        prettyPrintIndent = "  "
        serializersModule = SerializersModule {
            polymorphic(Params::class) {
                subclass(LogMessageParams::class)
                subclass(ShowMessageParams::class)
            }
        }
    }

    fun send(params: Params) {
        val string = json.encodeToString(
            ResponseMessage(
                //id = IntVal(0),
                method = params.method,
                params = params
            )
        )
        val length = string.toByteArray(Charsets.UTF_8).size
        writer.write("Content-Length: $length\r\n\r\n$string")
        writer.flush()
    }

    fun log(message: String, type: MessageType = MessageType.Log) = send(LogMessageParams(type = type, message = message))
    fun show(message: String, type: MessageType = MessageType.Log) = send(ShowMessageParams(type = type, message = message))

    fun initialize(params: InitializeParams) {
        log(json.encodeToString(params))
    }

    fun start() {
        while (true) {
            val line = reader.readLine() ?: break
            val empty = reader.readLine() ?: break
            if (empty.isNotEmpty()) {
                log("Not Empty: $empty", MessageType.Error)
                continue
            }

            val parts = line.split(":", limit = 2)
            if (parts.size != 2) continue
            if (parts.first() != "Content-Length") continue
            val contentLength = parts.last().trim().toIntOrNull() ?: continue

            val buffer = CharArray(contentLength)
            reader.read(buffer, 0, contentLength)
            val content = String(buffer)

            val message = try {
                json.decodeFromString<RequestMessage>(content)
            } catch (e: Exception) {
                log(e.stackTraceToString())
                log(content)
                continue
            }

            val p = message.params
            if (p != null) when (message.method) {
                InitializeParams.METHOD -> initialize(json.decodeFromJsonElement<InitializeParams>(InitializeParams.serializer(), message.params))
            }
        }
    }

    init {
        start()
    }
}
