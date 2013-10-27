import java.io.InputStream
import java.io.Reader
import java.io.BufferedReader

/*fun main(args: Array<String>) {
   println(calculateMatrix(BufferedReader(System.`in`.reader("UTF-8"))))
}*/

fun calculateMatrix(input: BufferedReader): String {
    val firstLine = input.readLine()!!.split(" ")
    val n = firstLine[0].toInt()
    val m = firstLine[1].toInt()
    val matrix = Array<IntArray>(n, { i -> IntArray(n)})
    for(i in matrix.indices){
        for(j in matrix.indices){
            if(i == j) matrix[i][j] = 0
            else matrix[i][j] = INFINITY
        }
    }
    for(t in (1..m)){
        val s = input.readLine()
        val line = s!!.split(" ")
        val i = line[0].toInt()
        val j = line[1].toInt()
        val weight = line[2].toInt()
        matrix[i - 1][j - 1] = weight
    }
    val processedMatrix = floyd(matrix)
    val result = StringBuilder()
    for(i in matrix.indices){
        for(j in matrix.indices){
            result.append(processedMatrix[i][j])
            if(j != n - 1) result.append(" ")
        }
        if(i != n - 1) result.append("\n")
    }
    return result.toString()
}

fun floyd(matrix: Array<IntArray>): Array<IntArray> {
    for(k in matrix.indices){
        for(i in matrix.indices){
            for(j in matrix.indices){
                matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j])
            }
        }
    }
    return matrix
}

val INFINITY = 10000

