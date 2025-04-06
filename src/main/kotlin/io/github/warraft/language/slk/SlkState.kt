package io.github.warraft.language.slk

// https://en.wikipedia.org/wiki/Symbolic_Link_(SYLK)
// https://outflank.nl/upload/sylksum.txt
// https://oss.sheetjs.com/notes/sylk/
// https://git.sheetjs.com/sheetjs/sheetjs/src/commit/0e4eb976e1171cb21ff4c2ed24abb604f6276e47/xlsx.mjs#L8395
// https://microsoft.fandom.com/wiki/SYmbolic_LinK_(SYLK)

import io.github.warraft.language._.state.LanguageState
import io.github.warraft.language.slk.psi.SlkRecordKind
import io.github.warraft.language.slk.psi.SlkValueKind
import io.github.warraft.lsp.data.InlayHint
import io.github.warraft.lsp.data.InlayHintLabelPart
import io.github.warraft.lsp.data.MarkupContent
import io.github.warraft.lsp.data.MarkupKind
import io.github.warraft.lsp.data.semantic.SemanticTokenType
import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.Lexer
import org.antlr.v4.runtime.Parser

class SlkState : LanguageState() {
    override fun lexer(stream: CharStream): Lexer? = null
    override fun parser(stream: CommonTokenStream): Parser? = null

    val p = SlkParser()

    override fun parse(stream: CharStream, states: List<LanguageState>, version: Int?) {
        if (!needParse(version)) return
        super.parse(stream, states, version)

        p.clear()
        p.parse(stream)

        var prevY = -1

        for (rec in p.record) {
            semanticHub.add(rec.name, SemanticTokenType.NAMESPACE)

            val xs = rec.x.toString().padStart(3, '0')
            val ys = rec.y.toString().padStart(3, '0')
            var yst = ys

            if (rec.kind == SlkRecordKind.Column) {
                if (rec.y == prevY) yst = "   "
                prevY = rec.y

                if (rec.y > 1) p.getValue(1, rec.x)?.s?.also {
                    inlayHint.add(
                        InlayHint(
                            position = rec.end,
                            label = listOf(InlayHintLabelPart(it)),
                            paddingLeft = true,
                        )
                    )
                }
            }

            inlayHint.add(
                InlayHint(
                    position = rec.name.range.start,
                    label = listOf(InlayHintLabelPart(value = if (rec.kind == SlkRecordKind.Column) "$yst $xs" else "       ")),
                    tooltip = MarkupContent(
                        kind = MarkupKind.Markdown,
                        value = "Y:**$ys**  \nX:**$xs**"
                    ),
                    paddingRight = true,
                )
            )

            for (fi in rec.field) {
                semanticHub.add(fi.name, SemanticTokenType.KEYWORD)
                fi.value?.also {
                    semanticHub.add(
                        it.text, when (it.kind) {
                            SlkValueKind.String -> SemanticTokenType.STRING
                            SlkValueKind.Number -> SemanticTokenType.NUMBER
                            SlkValueKind.Boolean -> SemanticTokenType.VARIABLE
                            SlkValueKind.Other -> SemanticTokenType.COMMENT
                        }
                    )
                }
            }
        }
    }
}
