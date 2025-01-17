import java.nio.file.Paths
import kotlin.io.path.absolute
import kotlin.test.Test

class JassLuaKtTest {
    private val cjp = Paths.get("src", "test", "resources", "sdk", "common.j")
    private val bjp = Paths.get("src", "test", "resources", "sdk", "blizzard.j")

    @Test
    fun keyword() {
        val wj = Paths.get("src", "test", "resources", "lua", "keyword.j")
        jassLuaProcess(
            arrayOf<String>(
                cjp.absolute().toString(),
                bjp.absolute().toString(),
                wj.absolute().toString(),
            )
        )
    }
}
