fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("No arguments provided!")
    } else {
        println("Arguments:")
        args.forEachIndexed { index, arg ->
            println("Argument $index: $arg")
        }
    }
}
