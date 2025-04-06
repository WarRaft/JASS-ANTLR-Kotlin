package io.github.warraft.lsp

import io.github.warraft.language._.state.LanguageState
import io.github.warraft.lsp.data.InitializeParams
import io.github.warraft.lsp.data.Message
import io.github.warraft.lsp.data.MessageLogParams
import io.github.warraft.lsp.data.MessageLogType
import io.github.warraft.lsp.ext.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonNull
import java.io.BufferedInputStream
import java.io.BufferedOutputStream
import java.nio.file.Path
import kotlin.system.exitProcess

// https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#headerPart
class LanguageServer {
    private val reader = BufferedInputStream(System.`in`)
    private val writer = BufferedOutputStream(System.`out`)

    internal val languageMap = mutableMapOf<Path, String>()
    internal val sdkStateList = mutableListOf<LanguageState>()
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

    fun message(params: MessageLogParams, method: String) =
        request(json.encodeToJsonElement(MessageLogParams.serializer(), params), method)

    fun log(msg: String, type: MessageLogType = MessageLogType.Log) =
        message(MessageLogParams(type = type, message = msg), MessageLogParams.LOG)

    fun show(msg: String, type: MessageLogType = MessageLogType.Log) =
        message(MessageLogParams(type = type, message = msg), MessageLogParams.SHOW)

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

    fun loop() {
        val line = readLine() ?: return

        val parts = line.split(":", limit = 2)
        if (parts.size != 2) return
        if (parts.first().trim() != CONTENT_LENGTH) {
            log("Missing Content-Length header: $line", MessageLogType.Error)
            return
        }
        val contentLength = parts.last().trim().toIntOrNull() ?: return

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
            return
        }

        when (message.method) {
            InitializeParams.METHOD -> initialize(message)
            "workspace/didChangeConfiguration" -> didChangeConfiguration(message)
            "textDocument/didChange" -> didChange(message)
            "textDocument/didOpen" -> didOpen(message)
            "textDocument/semanticTokens/full" -> semanticTokens(message)
            "textDocument/completion" -> completion(message)
            "textDocument/documentHighlight" -> documentHighlight(message)
            "textDocument/hover" -> hover(message)
            "textDocument/foldingRange" -> foldingRange(message)
            "textDocument/documentSymbol" -> documentSymbol(message)
            "textDocument/diagnostic" -> diagnostic(message)
            "textDocument/definition" -> definition(message)
            "textDocument/references" -> references(message)
            "textDocument/formatting" -> formatting(message)
            "textDocument/rename" -> rename(message)
            "textDocument/inlayHint" -> inlayHint(message)

            "initialized",
            "$/setTrace",
            "textDocument/didClose",
            "completionItem/resolve",
                -> {
            }

            "$/cancelRequest" -> cancel(message)
            "shutdown" -> {
                send(json.encodeToString(Message(id = message.id, result = JsonNull)))
            }

            "exit" -> exit = true
            else -> log("${message.id} - ${message.method}")
        }
    }

    @Volatile
    var exit = false

    @Volatile
    var shutdown = false

    private fun monitorParentProcess() {
        ProcessHandle.current().parent().ifPresent { parent ->
            Thread {
                while (parent.isAlive) {
                    Thread.sleep(1000)
                }
                exitProcess(0)
            }.start()
        }
    }

    fun start() {
        monitorParentProcess()

        Runtime.getRuntime().addShutdownHook(Thread {
            shutdown = true
        })

        while (true) {
            ProcessHandle.current().parent().ifPresentOrElse({ parent ->
                if (!parent.isAlive) exitProcess(0)
            }, {
                exitProcess(0)
            })

            if (exit) exitProcess(0)
            if (shutdown) break

            try {
                loop()
            } catch (e: Exception) {
                show(e.stackTraceToString(), MessageLogType.Error)
            }
        }
    }

    init {
        start()
    }

    companion object {
        const val CONTENT_LENGTH = "Content-Length"
    }
}

