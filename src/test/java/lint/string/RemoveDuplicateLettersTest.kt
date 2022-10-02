package lint.string

import ObjWrap
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class RemoveDuplicateLettersTest {

    @Test
    fun removeDuplicateLetters() {
        println(RemoveDuplicateLetters().removeDuplicateLetters("oriuuw"))
    }

    @Test
    fun a(){
        val int = ObjWrap(1)
        println(int.value)
        int.value = 10
        println(int.value)
        val c = 9
        println("${c+1}")
    }

}