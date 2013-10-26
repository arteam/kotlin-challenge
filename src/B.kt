/*fun main(args: Array<String>) {
   println(isLucky(readLine()!!))
}*/

fun isLucky(ticket: String): String {
    val ticketNumbers = ticket.toList().map { Character.getNumericValue(it) }
    val sumOfFirstTree = ticketNumbers.subList(0,3).reduce { total, next -> total + next }
    val sumOfLastTree = ticketNumbers.subList(3,6).reduce { total, next -> total + next }
    return if (sumOfFirstTree == sumOfLastTree) "Lucky ticket" else "Unlucky ticket"
}

