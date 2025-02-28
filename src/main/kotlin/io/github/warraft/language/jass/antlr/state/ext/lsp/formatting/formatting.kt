package io.github.warraft.language.jass.antlr.state.ext.lsp.formatting

import io.github.warraft.language.jass.antlr.state.JassState
import io.github.warraft.language.jass.antlr.state.ext.lsp.formatting.formatter.JassFormatter
import org.eclipse.lsp4j.DocumentFormattingParams
import org.eclipse.lsp4j.TextEdit

fun JassState.formattingEx(@Suppress("unused") params: DocumentFormattingParams?): List<TextEdit> = JassFormatter(this, rootCtx).fmt
