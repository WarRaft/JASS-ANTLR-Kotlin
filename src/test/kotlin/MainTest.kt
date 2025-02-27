import io.github.warraft.lsp.ResponseMessage
import io.github.warraft.lsp.method.window.logMessage.LogMessageParams
import io.github.warraft.lsp.method.window.MessageType
import kotlinx.serialization.json.Json
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.io.path.absolute
import kotlin.test.Test

class MainTest {
    private val cjp = Paths.get("src", "test", "resources", "sdk", "common.j")
    private val bjp = Paths.get("src", "test", "resources", "sdk", "blizzard.j")

    private fun jass(path: Path) {
        Main(
            arrayOf(
                "-jass2jass",
                cjp.absolute().toString(),
                bjp.absolute().toString(),
                path.absolute().toString(),
            )
        )
    }

    @Test
    fun json(){
        val r = ResponseMessage(
            method = "window/logMessage",
            params = LogMessageParams(
                type = MessageType.Info,
                message = "mEaaaaaadff "
            )
        )

        val m = Json.encodeToString(r)

        println(m)
    }

    @Test
    fun keywordJass() {
        jass(Paths.get("src", "test", "resources", "keyword.j"))
    }

    @Test
    fun testJass() {
        jass(Paths.get("src", "test", "resources", "jass", "test.j"))
    }

    @Test
    fun convertJass() {
        jass(Paths.get("src", "test", "resources", "check", "convert.j"))
    }

    @Test
    fun convertLua() {
        lua(Paths.get("src", "test", "resources", "check", "convert.j"))
    }

    private fun lua(path: Path) {
        Main(
            arrayOf(
                "-jass2lua",
                cjp.absolute().toString(),
                bjp.absolute().toString(),
                path.absolute().toString(),
            )
        )
    }

    @Test
    fun keywordLua() {
        lua(Paths.get("src", "test", "resources", "lua", "keyword.j"))
    }

    @Test
    fun concatenationLua() {
        lua(Paths.get("src", "test", "resources", "lua", "concatenation.j"))
    }

    @Test
    fun keyword() {
        lua(Paths.get("src", "test", "resources", "lua", "keyword.j"))
    }

    @Test
    fun ltd() {
        lua(Paths.get("src", "test", "resources", "map", "LTD.j"))
    }

    @Test
    fun lg() {
        lua(Paths.get("src", "test", "resources", "map", "LastGuard.j"))
    }

    private fun ass(path: Path) {
        Main(
            arrayOf(
                "-jass2as",
                cjp.absolute().toString(),
                bjp.absolute().toString(),
                path.absolute().toString(),
            )
        )
    }

    @Test
    fun convertAs() {
        ass(Paths.get("src", "test", "resources", "check", "convert.j"))
    }

    @Test
    fun lgAs() {
        ass(Paths.get("src", "test", "resources", "maps", "LastGuard.j"))
    }

}
