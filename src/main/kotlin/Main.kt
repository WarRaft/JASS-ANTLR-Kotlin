import raft.war.antlr.jass.JassState
import java.nio.file.Paths
import kotlin.io.path.absolute

fun main() {
    val cj = JassState()

    cj.parse(Paths.get("src", "test", "resources", "test.j").absolute().toString())
    //cj.parse(Paths.get("src", "test", "resources", "common.j").absolute().toString())

    if (cj.errors.isNotEmpty()) {
        cj.errors.forEach { print("$it \n") }
    }

    print(cj.globals)
}
