package xpertDp

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MaxProfitTest {

    @Test
    fun TestCase1() {
        val input = listOf(1, 25, 24, 23, 12, 36, 14, 40, 31, 41, 5)
        val output = maxProfitWithKTransactionsOneD(input, 2)
        val expected = 93
        assert(expected == output)
    }
}