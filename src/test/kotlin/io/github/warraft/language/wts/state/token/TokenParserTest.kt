package io.github.warraft.language.wts.state.token

import io.github.warraft.language.bni.state.Token
import kotlin.test.Test

class TokenParserTest {
    @Test
    fun parse() {
        val s = listOf<String>(
            """=0,musictheme,`Sound\\Music\\mp3Music\\Orc1.mp3`,WESTRING_MUSICTHEME_ORC1""",
            """="Learn Chemical |cffffcc00R|rage - [|cffffcc00Level %d|r]""""",
            """=13.2""",
            """="ae" 123 ,"45" """
        )[0]
        val root = Token.parse(s)
        println("🍒-->$s<--")
        for (t in root) {
            println(t)
        }
    }
}
