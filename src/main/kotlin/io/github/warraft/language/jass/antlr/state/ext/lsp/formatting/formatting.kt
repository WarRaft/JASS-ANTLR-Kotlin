package io.github.warraft.language.jass.antlr.state.ext.lsp.formatting

import io.github.warraft.language.jass.antlr.state.JassState
import io.github.warraft.language.jass.antlr.state.ext.lsp.formatting.formatter.JassFormatter
import io.github.warraft.lsp.data.TextEdit

fun JassState.formattingEx(): List<TextEdit>? = JassFormatter(this, rootCtx).fmt
