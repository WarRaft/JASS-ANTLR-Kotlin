package io.github.warraft.jass.antlr.state.ext.lsp4j.formatting.formatter.ext

import io.github.warraft.JassParser.FunctionContext
import io.github.warraft.JassParser.NativeRuleContext
import io.github.warraft.jass.antlr.state.ext.lsp4j.formatting.formatter.JassFormatter
import org.antlr.v4.runtime.ParserRuleContext

fun JassFormatter.function(ctx: ParserRuleContext?) {
    tab(ctx, 0)

    when (ctx) {
        is NativeRuleContext -> {

        }

        is FunctionContext -> {

        }

    }

}
