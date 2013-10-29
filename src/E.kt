import java.io.BufferedReader

fun main(args: Array<String>) {
    val reader = BufferedReader(System.`in`.reader("UTF-8"))
    println(maxSubstring(reader))
}

fun maxSubstring(input: BufferedReader): String {
    val m = input.readLine()!!.toInt()
    val firstString = input.readLine()!!.split(" ").map { it -> it.toInt() }
    val n = input.readLine()!!.toInt()
    val secondString = input.readLine()!!.split(" ").map { it -> it.toInt() }
    return processMatrix(firstString, secondString)
}

fun processMatrix(first: List<Int>, second: List<Int>): String {
    val m = first.size
    val n = second.size
    val matrix = Array<IntArray>(m + 1, { row -> IntArray(n + 1) })
    for (i in (0..m)) {
        for (j in (0..n)) {
            if(i == 0 || j == 0 || first.get(i - 1) != second[j - 1])
                matrix[i][j] = 0
            else
                matrix[i][j] = matrix[i - 1][j - 1] + 1
        }
    }

    var maxI = 0
    var maxJ = 0
    var max = 0
    for (i in (0..m)) {
        for (j in (0..n)) {
            if(matrix[i][j] > max) {
                max = matrix[i][j]
                maxI = i;
                maxJ = j;
            }
        }
    }

    val maxSubstring = first.subList(maxI - max, maxI)

    val result = StringBuilder(max.toString()).append("\n")
    for (i in (0..maxSubstring.size - 2)) {
        result.append(maxSubstring[i]).append(" ")
    }
    if(maxSubstring.size > 0)  result.append(maxSubstring[maxSubstring.size - 1])
    return result.toString()
}