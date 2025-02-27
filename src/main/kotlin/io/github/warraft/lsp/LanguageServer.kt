package io.github.warraft.lsp

import io.github.warraft.language._.antlr.state.LanguageState
import io.github.warraft.lsp.data.*
import io.github.warraft.lsp.ext.cancel
import io.github.warraft.lsp.ext.didChange
import io.github.warraft.lsp.ext.didOpen
import io.github.warraft.lsp.ext.initialize
import io.github.warraft.lsp.ext.semanticTokens
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import java.io.*
import java.lang.management.ManagementFactory
import java.nio.file.Path

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#headerPart
class LanguageServer {
    private val reader = BufferedInputStream(System.`in`)
    private val writer = BufferedOutputStream(System.`out`)

    internal val languageMap = mutableMapOf<Path, String>()
    internal val stateMap = mutableMapOf<Path, LanguageState>()

    val json = Json {
        classDiscriminator = "AnalClassDiscriminator"
        ignoreUnknownKeys = true
    }

    fun send(string: String) {
        val ba = string.toByteArray(Charsets.UTF_8)
        writer.write("$CONTENT_LENGTH:${ba.size}\r\n\r\n".toByteArray(Charsets.UTF_8))
        writer.write(ba)
        writer.flush()
    }

    fun request(element: JsonElement, method: String) = send(
        json.encodeToString(
            Message(
                method = method,
                params = element
            )
        )
    )

    fun message(params: MessageLogParams, method: String) = request(json.encodeToJsonElement(MessageLogParams.serializer(), params), method)
    fun log(msg: String, type: MessageLogType = MessageLogType.Log) = message(MessageLogParams(type = type, message = msg), MessageLogParams.LOG)
    fun show(msg: String, type: MessageLogType = MessageLogType.Log) = message(MessageLogParams(type = type, message = msg), MessageLogParams.SHOW)

    fun readLine(): String? {
        val buffer = StringBuilder()
        var lastFourChars = ""

        while (true) {
            val byte = reader.read()
            if (byte == -1 && buffer.isEmpty()) return null
            if (byte == -1) break

            val char = byte.toChar()
            buffer.append(char)

            lastFourChars = (lastFourChars + char).takeLast(4)
            if (lastFourChars == "\r\n\r\n") break
        }

        return buffer.toString().trimEnd()
    }

    fun start() {
        while (true) {
            val line = readLine() ?: break

            val parts = line.split(":", limit = 2)
            if (parts.size != 2) continue
            if (parts.first().trim() != CONTENT_LENGTH) {
                log("Missing Content-Length header: $line", MessageLogType.Error)
                continue
            }
            val contentLength = parts.last().trim().toIntOrNull() ?: continue

            val buffer = ByteArray(contentLength)
            var totalBytesRead = 0

            while (totalBytesRead < contentLength) {
                val bytesRead = reader.read(buffer, totalBytesRead, contentLength - totalBytesRead)
                if (bytesRead == -1) {
                    log("Unexpected end of stream. Bytes read: $totalBytesRead / $contentLength", MessageLogType.Error)
                    break
                }
                totalBytesRead += bytesRead
            }

            val content = String(buffer, 0, totalBytesRead)

            val message = try {
                json.decodeFromString<Message>(content)
            } catch (e: Exception) {
                log("Invalid Message: ${e.message}", MessageLogType.Error)
                log(content)
                continue
            }

            when (message.method) {
                InitializeParams.METHOD -> initialize(message)
                "textDocument/didChange" -> didChange(message)
                "textDocument/didOpen" -> didOpen(message)
                "textDocument/semanticTokens/full" -> semanticTokens(message)
                "$/cancelRequest" -> cancel(message)
                "$/setTrace" -> {}

                else -> log("${message.id} - ${message.method}")
            }
        }
    }

    init {
        start()
    }

    @Suppress("unused")
    fun getHeapMemoryUsage(): String {
        val memoryMXBean = ManagementFactory.getMemoryMXBean()
        val heapUsage = memoryMXBean.heapMemoryUsage
        val nonHeapUsage = memoryMXBean.nonHeapMemoryUsage

        return """
        Heap Memory: Used = ${heapUsage.used / 1024 / 1024}MB, Max = ${heapUsage.max / 1024 / 1024}MB
        Non-Heap Memory: Used = ${nonHeapUsage.used / 1024 / 1024}MB
    """.trimIndent()
    }


    companion object {
        const val CONTENT_LENGTH = "Content-Length"
    }
}

