import java.io.BufferedReader
import java.util.ArrayList

fun main(args: Array<String>) {
    val reader = BufferedReader(System.`in`.reader("UTF-8"))
    println(floyd(reader))
}

fun floyd(input: BufferedReader): String {
    val firstLine = input.readLine()!!.split(" ").map { it -> it.toInt() }
    val n = firstLine[0]
    var m = firstLine[1]
    val cap = Array(n) { Array(n) { 0 } }
    while (m-- > 0){
        val row = input.readLine()!!.split(" ").map { it -> it.toInt() }
        cap[row[0] - 1][row[1] - 1] = row[2]
    }

    val from = 0;
    val to = n - 1;
    var flow = 0
    while (true){
        if(from == to) return "0"
        val innerFlow = findPath(from, to, BooleanArray(n), Integer.MAX_VALUE, cap)
        if(innerFlow == 0 || innerFlow==Integer.MAX_VALUE) return flow.toString()
        flow += innerFlow
    }

}


fun findPath(a: Int, b: Int, visited: BooleanArray, flow: Int, cap: Array<Array<Int>>): Int {
    if(a == b)
      return flow
    visited[a] = true
    for (i in (0..visited.size - 1)) {
        if(cap[a][i] > 0 && !visited[i]){
            val innerFlow = findPath(i, b, visited, Math.min(flow, cap[a][i]), cap)
            if(innerFlow > 0 ){
                cap[a][i] -= innerFlow
                cap[i][a] += innerFlow
                return innerFlow
            }
        }
    }
    return 0
}


