package challenge

import org.junit.Test
import kotlin.test.assertEquals

class CTest{
    Test fun test1(){
        val result = amountSumsOfPrimeNumbers("5")
        assertEquals(1, result)
    }

    Test fun test2(){
        val result = amountSumsOfPrimeNumbers("10")
        assertEquals(2, result)
    }

    Test fun test3(){
        val result = amountSumsOfPrimeNumbers("22")
        assertEquals(3, result)
    }

    Test fun test4(){
        val result = amountSumsOfPrimeNumbers("15")
        assertEquals(1, result)
    }
}