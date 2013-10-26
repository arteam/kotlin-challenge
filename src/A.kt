/*fun main(args: Array<String>) {
    println(calculate(readLine()!!))
}*/

fun calculate(line: String) : Int {
    val numbers = line.split(" ").map { it.toInt() }
    return numbers[0] + numbers[1]
}
