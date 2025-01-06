import raft.war.jass.JassState
import raft.war.lua.JassLua
import java.nio.file.Paths
import kotlin.io.path.absolute

fun main() {
    val jass = JassState()

    val jassPath = Paths.get("src", "test", "resources", "blizzard.j")
    val luaPath = jassPath.resolveSibling(jassPath.fileName.toString().replaceAfterLast('.', "lua"))

    jass.parse(jassPath.absolute().toString())

    jass.errors.forEach { print("$it \n") }

    val lua = JassLua(jass, luaPath)

    lua.convert()
}
