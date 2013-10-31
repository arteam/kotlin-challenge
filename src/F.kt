import java.io.BufferedReader

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
        val row = input.readLine()!!.split(" ")
        cap[row[0].toInt()-1][row[1].toInt()-1]=row[2].toInt()
    }

    val from = 0;
    val to = n-1;

    fun findPath(a: Int, b: Int, visited: BooleanArray, flow: Int): Int {
        if(a == b) return flow
        visited[a] = true
        for (i in (0..n-1)) {
            if(cap[a][i] > 0 && !visited[i]){
                val innerFlow = findPath(i, b, visited, Math.min(flow, cap[a][i]))
                if(innerFlow > 0){
                    cap[a][i] -= innerFlow
                    cap[i][a] += innerFlow
                    return innerFlow
                }
            }
        }
        return 0
    }

    var flow = 0
    while (true){
        val innerFlow = findPath(from, to, BooleanArray(n), Integer.MAX_VALUE)
        if(innerFlow == 0) return flow.toString()
        flow += innerFlow
    }
}