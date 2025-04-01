package io.github.warraft.language.slk.state

import io.github.warraft.language._.state.LanguageState
import io.github.warraft.lsp.data.semantic.SemanticTokenType
import org.antlr.v4.runtime.*
import org.antlr.v4.runtime.misc.Interval

// https://en.wikipedia.org/wiki/Symbolic_Link_(SYLK)
// https://outflank.nl/upload/sylksum.txt

class SlkState : LanguageState() {
    override fun lexer(stream: CharStream): Lexer? = null
    override fun parser(stream: CommonTokenStream): Parser? = null

    private enum class Mode {

        Val,

    }

    override fun parse(stream: CharStream, states: List<LanguageState>, version: Int?) {
        if (!needParse(version)) return
        super.parse(stream, states, version)

        var line = 0
        var col = -1
        var index = -1

        fun nextSymbol(): String? {
            col++
            index++
            stream.seek(index)
            if (stream.LA(1) == IntStream.EOF) return null
            return stream.getText(Interval(index, index))
        }

        var si = 0
        var isEnd = false

        var recMode = true
        var recName = ""
        fun recCommit() {
            if (!recMode) return
            recMode = false
            //println("🔥|$recName|")
            semanticHub.add(line = line, pos = si, len = col - si, SemanticTokenType.NAMESPACE)
            if (recName == "E") isEnd = true
        }

        var fd = ""
        var valBody = ""
        var valMode = false

        fun valCommit() {
            if (!valMode) return
            println("🍒$recName|$fd|$valBody|")
            fd = ""
            valBody = ""
            valMode = false
            semanticHub.add(line = line, pos = si, len = col - si + 1, SemanticTokenType.STRING)
        }

        fun nextLine() {
            recCommit()
            valCommit()
            recMode = true
            recName = ""
            si = 0
            col = -1
            line++
        }

        while (true) {
            if (isEnd) break
            val ch = nextSymbol() ?: break

            when (ch.codePointAt(0)) {
                13 -> {
                    if (stream.LA(2) == 10) index++
                    nextLine()
                    continue
                }

                10 -> {
                    nextLine()
                    continue
                }

                59 /*;*/ -> {
                    recCommit()

                    if (valMode) {

                    }


                    if (valMode && stream.LA(2) == 59) {
                        index++
                        col++
                    } else {
                        valCommit()
                        //semanticHub.add(line = line, pos = col - 1, len = 2, SemanticTokenType.KEYWORD)
                        valMode = true
                        si = col + 1
                        continue
                    }
                }
            }
            if (col < 0) continue
            if (recMode) recName += ch
            if (valMode) valBody += ch

            println("$ch - line: $line, col: $col, index: $index, ch: (${ch.codePointAt(0)}) ")
        }
    }
}
