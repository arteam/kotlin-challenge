import java.io.BufferedReader
import java.util.Stack
import java.util.Deque
import java.util.ArrayDeque

/*
fun main(args: Array<String>) {
    val reader = BufferedReader(System.`in`.reader("UTF-8"))
    println(maxSubstring(reader))
}*/

fun maxSubstring(input: BufferedReader): String {
    val m = input.readLine()!!.toInt()
    val firstString = input.readLine()!!.split(" ").map { it -> it.toInt() }
    assert(m == firstString.size)
    val n = input.readLine()!!.toInt()
    val secondString = input.readLine()!!.split(" ").map { it -> it.toInt() }
    assert(n == secondString.size)
    return processMatrix(firstString, secondString)
}


fun processMatrix(first: List<Int>, second: List<Int>): String {
    val m = first.size
    val n = second.size
    val matrix = Array(m + 1) { Array(n + 1) { 0 } }
    for (i in (1..m)) {
        for (j in (1..n)) {
            if(first[i - 1] == second[j - 1])
                matrix[i][j] = matrix[i - 1][j - 1] + 1
            else
                matrix[i][j] = Math.max(matrix[i][j - 1], matrix[i - 1][j])
        }
    }

    val reverseSeq = ArrayDeque<Int>()
    var i = m;
    var j = n;
    while (matrix[i][j] != 0 && i > 0 && j > 0) {
        if(first[i - 1] == second[j - 1])   {
            reverseSeq.push(first[i - 1])
            i--
            j--
        } else {
            if(matrix[i][j] == matrix[i - 1][j])  i--  else j--
        }
    }

    val result = StringBuilder(matrix[m][n].toString())
    if(reverseSeq.size > 0){
        result.append("\n")
        while (reverseSeq.size > 1)        {
            result.append(reverseSeq.pop()).append(" ")
        }
        result.append(reverseSeq.pop())
    }
    return result.toString()
}