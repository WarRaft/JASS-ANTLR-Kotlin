package io.github.warraft.jass.antlr.state.ext.lsp4j.formatting

import io.github.warraft.jass.antlr.state.JassState
import io.github.warraft.jass.antlr.state.ext.lsp4j.formatting.formatter.JassFormatter
import org.eclipse.lsp4j.DocumentFormattingParams
import org.eclipse.lsp4j.TextEdit

fun JassState.formattingEx(@Suppress("unused") params: DocumentFormattingParams?): List<TextEdit> = JassFormatter(this, rootCtx).fmt
