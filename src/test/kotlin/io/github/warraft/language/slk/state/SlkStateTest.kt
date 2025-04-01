package io.github.warraft.language.slk.state

import io.github.warraft.language._.state.LanguageState
import org.antlr.v4.runtime.CharStreams
import java.nio.file.Paths
import kotlin.test.Test

class SlkStateTest {

    @Test
    fun test() {
        //val p = Paths.get("src", "test", "resources", "slk", "T_SplatData.slk")
        val p = Paths.get("src", "test", "resources", "slk", "Empty.slk")

        SlkState().also {
            it.parse(
                CharStreams.fromPath(p),
                emptyList<LanguageState>(),
                null
            )
        }


    }
}
