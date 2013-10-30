package challenge

import org.junit.Test
import kotlin.test.assertEquals
import java.io.BufferedReader
import java.io.StringReader

class ETest{
    Test fun test1() {
        val result = maxSubstring(BufferedReader(StringReader(
                """3
1 2 3
4
2 3 1 5""")))
        assertEquals(
                """2
2 3""", result)
    }

    Test fun test2() {
        val result = maxSubstring(BufferedReader(StringReader(
                """5
1 2 3 4 5
4
8 2 3 4""")))
        assertEquals(
                """3
2 3 4""", result)
    }

    Test fun test3() {
        val result = maxSubstring(BufferedReader(StringReader(
                """5
1 2 3 4 5
4
8 9 7 6""")))
        assertEquals(
                """0""", result)
    }

    Test fun test4() {
        val result = maxSubstring(BufferedReader(StringReader(
                """5
1 2 3 4 5
4
8 5 7 6""")))
        assertEquals(
                """1
5""", result)
    }

    Test fun test5() {
        val result = maxSubstring(BufferedReader(StringReader(
                """1
1
1
2""")))
        assertEquals(
                """0""", result)
    }

    Test fun test6() {
        val result = maxSubstring(BufferedReader(StringReader(
                """5
-1 -2 -3 -4 -5
3
-2 -3 -8""")))
        assertEquals(
                """2
-2 -3""", result)
    }

    Test fun test7() {
        val result = maxSubstring(BufferedReader(StringReader(
                """5
-1 -2 3 -4 5
6
1 -2 3 -4 5 -8""")))
        assertEquals(
                """4
-2 3 -4 5""", result)
    }

    Test fun test8() {
        val result = maxSubstring(BufferedReader(StringReader(
                """8
0 9 -2 8 4 4 4 3
8
1 0 9 2 4 4 4 2""")))
        assertEquals(
                """5
0 9 4 4 4""", result)
    }
}