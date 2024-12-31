import raft.war.jass.State
import java.nio.file.Paths
import kotlin.io.path.absolute

fun main() {
    val cj = State()

    cj.parse(Paths.get("src", "test", "resources", "a.j").absolute().toString())

    if (cj.errors.isNotEmpty()) {
        cj.errors.forEach { print("$it \n") }
    }
}
