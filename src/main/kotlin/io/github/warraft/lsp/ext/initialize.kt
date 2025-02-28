package io.github.warraft.lsp.ext

import io.github.warraft.language._.lsp4j.service.document.semantic.token.SemanticTokenModifier
import io.github.warraft.language._.lsp4j.service.document.semantic.token.SemanticTokenType
import io.github.warraft.lsp.LanguageServer
import io.github.warraft.lsp.data.CompletionOptions
import io.github.warraft.lsp.data.CompletionOptions.CompletionItem
import io.github.warraft.lsp.data.InitializeResult
import io.github.warraft.lsp.data.Message
import io.github.warraft.lsp.data.SemanticTokensLegend
import io.github.warraft.lsp.data.SemanticTokensOptions
import io.github.warraft.lsp.data.ServerCapabilities
import io.github.warraft.lsp.data.TextDocumentSyncKind
import io.github.warraft.lsp.data.TextDocumentSyncOptions

private fun case(str: String): String = str.split("_")
    .mapIndexed { index, s -> if (index == 0) s.lowercase() else s.lowercase().replaceFirstChar { it.uppercaseChar() } }.joinToString("")

fun LanguageServer.initialize(message: Message) = send(
    json.encodeToString(
        Message(
            id = message.id,
            result = json.encodeToJsonElement(
                InitializeResult.serializer(), InitializeResult(
                    capabilities = ServerCapabilities(
                        textDocumentSync = TextDocumentSyncOptions(
                            openClose = true,
                            change = TextDocumentSyncKind.Full
                        ),
                        semanticTokensProvider = SemanticTokensOptions(
                            range = false,
                            full = true,
                            legend = SemanticTokensLegend(
                                SemanticTokenType.entries.map { it -> case(it.name) },
                                SemanticTokenModifier.entries.map { it -> case(it.name) },
                            )
                        ),
                        completionProvider = CompletionOptions(
                            resolveProvider = true,
                            completionItem = CompletionItem(
                                labelDetailsSupport = true
                            )
                        )
                    )
                )
            )
        )
    )
)
