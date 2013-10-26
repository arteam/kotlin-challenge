import org.junit.Test
import kotlin.test.assertEquals

class BTest{
    Test fun test1() {
        val result = isLucky("123456")
        assertEquals("Unlucky ticket",result)
    }

    Test fun test2() {
        val result = isLucky("111111")
        assertEquals("Lucky ticket", result)
    }

    Test fun test3() {
        val result = isLucky("219318")
        assertEquals("Lucky ticket", result)
    }
}
