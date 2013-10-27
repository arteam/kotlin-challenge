package challenge

import org.junit.Test
import kotlin.test.assertEquals
import java.io.BufferedReader
import java.io.StringReader

class DTest{
    Test fun test1(){
        val result = calculateMatrix(BufferedReader(StringReader(
"""3 3
1 2 5
2 3 2
3 1 8""")))
assertEquals(
"""0 5 7
10 0 2
8 13 0""", result)
    }
}