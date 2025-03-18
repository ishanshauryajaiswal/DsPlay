package leet

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PermutationsTest{
    @Test
    fun TestCase1() {
        val output = Permutations().permute(IntArray(3){i -> i+1})
        print(output)
        assert(true)
    }
}