package `xpert-dp`

import org.junit.jupiter.api.Test


internal class MakeChangeTest {

    @Test
    fun test() {
        val denoms = listOf(1,2,3,4)
        val output = MakeChange().numberOfWaysToMakeChange(4, denoms)
        val expected = 5
        assert((expected == output))
    }
}