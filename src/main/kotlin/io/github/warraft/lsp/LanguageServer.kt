package io.github.warraft.lsp

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

@Serializable
data class JsonRpcRequest(val jsonrpc: String, val id: Int?, val method: String, val params: JsonElement? = null)

@Serializable
data class JsonRpcResponse<T>(val jsonrpc: String = "2.0", val id: Int?, val result: T? = null, val error: JsonRpcError? = null)

@Serializable
data class JsonRpcError(val code: Int, val message: String)

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#headerPart
class LanguageServer {
    private val reader = BufferedReader(InputStreamReader(System.`in`))
    private val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    fun start() {
        while (true) {
            val line = reader.readLine() ?: break
            if (line.isEmpty()) continue

            // https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#window_logMessage

            val notification = """
        {
            "jsonrpc": "2.0",
            "method": "window/logMessage",
            "params": {
                "type": 3,
                "message": "Это тестовое сообщение для лога"
            }
        }
    """.trimIndent()


            val contentLength = notification.toByteArray(Charsets.UTF_8).size
            val message = "Content-Length: $contentLength\r\n\r\n$notification"

            writer.write(message)
            writer.flush()

        }

        //println("🔥Starting LSP server...")
        /*
        while (true) {
            val input = reader.readLine() ?: break
            val d = try {
                Json.decodeFromString<JsonRpcRequest>(input)
            } catch (e: Exception) {
                println(input)
                e.printStackTrace()
                return
            }

            handleRequest(d)
        }

         */
    }

    init {
        start()
    }

    private fun handleRequest(request: JsonRpcRequest) {
        val response = when (request.method) {
            "initialize" -> JsonRpcResponse(id = request.id, result = mapOf("capabilities" to emptyMap<String, Any>()))
            "shutdown" -> JsonRpcResponse(id = request.id, result = null)
            else -> JsonRpcResponse(id = request.id, error = JsonRpcError(-32601, "Method not found"))
        }

        writer.write(Json.encodeToString(response) + "\n")
        writer.flush()
    }
}
