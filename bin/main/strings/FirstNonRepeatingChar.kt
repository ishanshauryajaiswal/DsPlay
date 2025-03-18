package strings

import java.util.*

class FirstNonRepeatingChar {

    fun firstNonRepeatingCharacter(string: String): Int {
        val map = HashMap<Char, Int>()
        for(i in 0..string.length-1){
            val char = string[i]
            map.put(char, map.getOrDefault(char, 0)+1)
        }
        for(i in 0..string.length-1){
            val char = string[i]
            if (map.get(char) == 1){
                return i
            }
        }
        return -1
    }

    /*
    Palindrome check
    https://www.algoexpert.io/questions/palindrome-check
     */

    fun isPalindrome(string: String): Boolean {
        var left = 0
        var right = string.length - 1
        while (right > left) {
            if (string[left] != string[right])
                return false
            left++
            right--
        }
        return true
    }

    /*
    https://www.algoexpert.io/questions/reverse-words-in-string
    Reverse words in string
    */

    fun reverseWordsInString(string: String): String {
        val builder = StringBuilder()
        var ans = ""
        for (i in 0..string.length-1){
            val char = string[i]
            if(char != ' '){
                builder.append(i)
            }
            else{
                ans = " " + builder.toString() + ans
                builder.delete(0, builder.length)
            }
        }
        return builder.toString()+ans
    }
}