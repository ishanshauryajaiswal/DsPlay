package leet

import ObjWrap
import org.junit.jupiter.api.Test
import swap

internal class WordBreakTest{

    @Test
    fun test(){
        WordBreak().wordBreak("", ArrayList())
    }

    @Test
    fun a(){
        val int1 = ObjWrap(1)
        val int2 = ObjWrap(2)
        println("$int1   $int2")
        swap(int1, int2)
        println("$int1   $int2")
    }
}