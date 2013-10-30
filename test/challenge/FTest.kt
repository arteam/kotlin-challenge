package challenge

import org.junit.Test
import kotlin.test.assertEquals
import java.io.BufferedReader
import java.io.StringReader

class FTest{
    Test fun test1(){
        val result : String = floyd(BufferedReader(StringReader(
"""4 5
1 2 1
1 3 2
3 2 1
2 4 2
3 4 1""")))
assertEquals(
"""3""", result)
    }

    Test fun test2(){
        val result : String = floyd(BufferedReader(StringReader(
                """6 9
1 2 10
1 3 10
2 3 2
2 4 4
2 5 8
3 5 9
5 4 6
5 6 10
4 6 10""")))
        assertEquals(
                """19""", result)
    }
}