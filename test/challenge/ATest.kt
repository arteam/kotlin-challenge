import org.junit.Test
import kotlin.test.assertEquals

class ATest {

    Test fun test1(){
        val result = calculate("24 12")
        assertEquals(36, result)
    }

    Test fun test2(){
        val result = calculate("17 -18")
        assertEquals(-1, result)
    }
}