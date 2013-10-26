fun main(args: Array<String>) {
    println(amountSumsOfPrimeNumbers(readLine()!!))
}

fun amountSumsOfPrimeNumbers(line: String): Int {
    val number = line.toInt()
    val lessPrimeNumbers = buildPrimeNumbersTable(number)
    var count = 0
    for (i in (0..lessPrimeNumbers.size - 1)) {
        for (j in (i..lessPrimeNumbers.size - 1)) {
            if(lessPrimeNumbers[i] + lessPrimeNumbers[j] == number)
                count++
        }
    }
    return count
}

fun buildPrimeNumbersTable(toNumber: Int): List<Int> {
    val table = arrayListOf(2)
    for(i in (3..1000)){
        if(i % 2 == 0) continue
        if(i > toNumber) break
        var isPrime = true;
        for (prime in table) {
            if(i % prime == 0)    {
                isPrime = false
                break
            }
        }
        if(isPrime) table.add(i)
    }
    return table;
}