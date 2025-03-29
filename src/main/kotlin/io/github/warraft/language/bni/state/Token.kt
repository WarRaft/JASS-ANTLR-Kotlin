package io.github.warraft.language.bni.state

data class Token(
    val type: TokenType,
    val start: Int,
    val length: Int,
    val text: String,
    private val children: List<Token> = emptyList(),
) {
    enum class TokenType { STRING, TEXT, NUMBER, COMMENT, COMMA }

    override fun toString(): String = "$type[$start, ${start + length - 1}] |$text|"

    companion object {
        private val numberRegex = Regex("""^\s*(-?(?:\d+\.?\d*|\.\d+))\s*$""")

        private enum class Mode {
            Search,
            Text,
            String,
            Comma,
            Comment,
        }

        fun parse(input: String): MutableList<Token> {
            val elements = mutableListOf<Token>()

            var pos = 0
            var tpos = 0
            var start = -1

            var mode = Mode.Search

            fun commit(pos: Int) {
                if (start < 0 || start > pos) return
                if (mode == Mode.Search) return
                val text = input.substring(start, pos + 1)

                elements.add(
                    Token(
                        type = when (mode) {
                            Mode.Comma -> TokenType.COMMA
                            Mode.Text -> TokenType.TEXT
                            Mode.String -> if (numberRegex.matches(text)) TokenType.NUMBER else TokenType.STRING
                            else -> TokenType.COMMENT
                        },
                        start = start,
                        length = pos - start + 1,
                        text = text
                    )
                )

                //println("commit: $mode [$start|$pos] ➡️|$text|⬅️")

                mode = Mode.Search
                start = -1
            }

            val ln = input.length - 1
            var tchar = '0'

            while (pos < ln) {
                pos++
                //println("🔥$pos|${input[pos]}|$mode")
                val ch = input[pos]
                when (ch) {
                    '\t',
                    ' ',
                        -> {
                        when (mode) {
                            Mode.String,
                            Mode.Search,
                                -> {
                                //println("|${input[pos + 1]}|")
                                if (pos < ln && input.startsWith("//", pos + 1)) {
                                    commit(pos - 1)
                                    mode = Mode.Comment
                                    start = pos + 1
                                }
                            }

                            else -> {}
                        }
                    }

                    ',' -> {
                        when (mode) {
                            Mode.String -> {
                                commit(tpos)

                                mode = Mode.Comma
                                start = pos
                                commit(pos)
                            }

                            Mode.Search -> {
                                start = pos
                                commit(pos)
                            }

                            else -> {}
                        }
                    }

                    '`',
                    '\'',
                    '"',
                        -> {
                        when (mode) {
                            Mode.Search -> {
                                tchar = ch
                                mode = Mode.Text
                                start = pos
                                continue
                            }

                            Mode.Text -> {
                                if (ch != tchar) continue
                                start++
                                commit(pos - 1)
                                continue
                            }

                            else -> {}
                        }
                    }

                    else -> {
                        tpos = pos
                        when (mode) {
                            Mode.Search -> {
                                start = pos
                                mode = Mode.String
                                continue
                            }

                            else -> {}
                        }

                    }

                }
            }
            commit(tpos)

            return elements
        }
    }
}
