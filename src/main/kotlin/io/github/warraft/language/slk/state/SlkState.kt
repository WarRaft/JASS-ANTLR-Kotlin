package io.github.warraft.language.slk.state

import io.github.warraft.language._.state.LanguageState
import io.github.warraft.lsp.data.InlayHint
import io.github.warraft.lsp.data.InlayHintLabelPart
import io.github.warraft.lsp.data.MarkupContent
import io.github.warraft.lsp.data.MarkupKind
import io.github.warraft.lsp.data.Position
import io.github.warraft.lsp.data.semantic.SemanticTokenType.*
import org.antlr.v4.runtime.*
import org.antlr.v4.runtime.misc.Interval

// https://en.wikipedia.org/wiki/Symbolic_Link_(SYLK)
// https://outflank.nl/upload/sylksum.txt
// https://oss.sheetjs.com/notes/sylk/
// https://git.sheetjs.com/sheetjs/sheetjs/src/commit/0e4eb976e1171cb21ff4c2ed24abb604f6276e47/xlsx.mjs#L8395

class SlkState : LanguageState() {
    override fun lexer(stream: CharStream): Lexer? = null
    override fun parser(stream: CommonTokenStream): Parser? = null

    private val numberRegex = Regex("""^(-?(?:\d+\.?\d*|\.\d+))$""")

    private enum class Mode {
        Record,
        Value,
        End
    }

    override fun parse(stream: CharStream, states: List<LanguageState>, version: Int?) {
        if (!needParse(version)) return
        super.parse(stream, states, version)

        var line = 0
        var col = -1
        var index = -1

        var x = 0
        var y = 0

        val headMap = mutableMapOf<Int, String>()

        fun nextSymbol(): String? {
            col++
            index++
            stream.seek(index)
            if (stream.LA(1) == IntStream.EOF) return null
            return stream.getText(Interval(index, index))
        }

        var mode = Mode.Record

        var si = 0

        var rec = ""
        var recHub = ""
        fun recCommit() {
            if (mode != Mode.Record) return
            rec = recHub
            recHub = ""
            semanticHub.add(line = line, pos = si, len = col - si, NAMESPACE)
            if (rec == "E") mode = Mode.End
            //println("Record:|$rec|")
        }

        var fd: String? = ""
        fun fdCommit() {
            fd = nextSymbol()
            semanticHub.add(line = line, pos = col - 1, len = 2, KEYWORD)
        }

        var va = ""
        var valHub = ""
        fun valCommit() {
            if (mode != Mode.Value) return

            var t = COMMENT
            if (numberRegex.matches(valHub)) t = NUMBER
            if (valHub.startsWith("\"") && valHub.endsWith("\"")) t = STRING

            //println("Value:|$rec|$fd|$valHub|")

            if (rec != "B" && t == NUMBER) when (fd) {
                "X" -> x = valHub.toIntOrNull() ?: 1
                "Y" -> y = valHub.toIntOrNull() ?: 1
            }

            semanticHub.add(line = line, pos = si + 1, len = col - si - 1, t)
            fd = ""
            va = valHub
            valHub = ""
        }

        while (true) {
            if (mode == Mode.End) break
            val ch = nextSymbol()
            if (ch == null) {
                recCommit()
                break
            }

            //println("🔥${ch.trim()} - ${mode.name}")

            var endLine = false

            when (ch.codePointAt(0)) {
                13 /* \r */ -> {
                    if (stream.LA(2) == 10) index++
                    endLine = true
                }

                10 /* \n */ -> endLine = true

                59 /* ; */ -> {
                    when (mode) {
                        Mode.Record -> {
                            recCommit()
                            valCommit()
                            fdCommit()
                            si = col
                            mode = Mode.Value
                            continue
                        }

                        Mode.Value -> {
                            if (stream.LA(2) == 59) {
                                index++
                                col++
                            } else {
                                valCommit()
                                fdCommit()
                                si = col
                                continue
                            }
                        }

                        Mode.End -> break
                    }
                }
            }

            if (endLine) {
                valCommit()
                recCommit()
                mode = Mode.Record

                val xs = x.toString().padStart(3, '0')
                val ys = y.toString().padStart(3, '0')

                if (y == 1) {
                    headMap[x] = va
                } else if (rec == "C") {
                    val v = headMap[x]
                    if (v != null) {
                        inlayHint.add(
                            InlayHint(
                                position = Position(line = line.toUInt(), character = col.toUInt()),
                                label = listOf(InlayHintLabelPart(value = v)),
                                paddingLeft = true,
                            )
                        )
                    }
                }

                inlayHint.add(
                    InlayHint(
                        position = Position(line = line.toUInt(), character = 0u),
                        label = listOf(InlayHintLabelPart(value = if (rec == "C") "$ys $xs" else "       ")),
                        tooltip = MarkupContent(
                            kind = MarkupKind.Markdown,
                            value = """Y:**$ys**  
                                |X:**$xs**""".trimMargin()
                        ),
                        paddingRight = true,
                    )
                )

                si = 0
                col = -1
                line++
            }

            if (col < 0) continue
            when (mode) {
                Mode.Record -> recHub += ch
                Mode.Value -> valHub += ch
                Mode.End -> break
            }

            //println("$ch - line: $line, col: $col, index: $index, ch: (${ch.codePointAt(0)}) ")
        }
    }
}
