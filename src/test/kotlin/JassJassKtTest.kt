import org.junit.jupiter.api.Test
import java.nio.file.Paths
import kotlin.io.path.absolute

class JassJassKtTest {
    private val cjp = Paths.get("src", "test", "resources", "sdk", "common.j")
    private val bjp = Paths.get("src", "test", "resources", "sdk", "blizzard.j")

    @Test
    fun keyword() {
        val wj = Paths.get("src", "test", "resources", "lua", "keyword.j")
        jassJassProcess(
            arrayOf<String>(
                cjp.absolute().toString(),
                bjp.absolute().toString(),
                wj.absolute().toString(),
            )
        )
    }

}
