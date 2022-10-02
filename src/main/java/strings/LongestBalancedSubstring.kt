package strings

import java.util.*

class LongestBalancedSubstring {

    fun main(args: Array<String>) {

    }

    fun longestBalancedSubstring(string: String): Int {
        val x = fillLeft("()()((()()))()()")
        print(x)
        return 0
    }

    fun fillLeft(string : String): Array<Obj>{
        val size = string.length
        val array = Array(size){Obj()}
        for(i in 0..size-1){
            var j = i
            var count = 0
            var temp = 0
            var closing = 0
            var open = 0
            while (j >= 0){
                val char = string[j]
                if(char == '('){
                    if(closing > 0){
                        temp+=2
                        closing--
                    }
                    else{
                        open++
                    }
                }
                else{
                    if (open > 0){
                        break
                    }
                    closing++
                }
                if(closing == 0){
                    count+=temp
                    temp = 0
                }
                array[i] = Obj(count, open)
                j--
            }
        }
        return array
    }

    fun fillRight(string : String): Array<Obj>{
        val size = string.length
        val array = Array(size){Obj()}
        for(i in size-1..0 step -1){
            var j = i + 1
            var count = 0
            var temp = 0
            var closing = 0
            var open = 0
            while (j < size){
                val char = string[j]
                if(char == '('){
                    if(closing > 0){
                        temp+=2
                        closing--
                    }
                    else{
                        open++
                    }
                }
                else{
                    if (open > 0){
                        break
                    }
                    closing++
                }
                if(closing == 0){
                    count+=temp
                    temp = 0
                }
                array[i] = Obj(count, open)
                j++
            }
        }
        return array
    }

    fun longestBalancedSubstringBrute(string: String): Int {
        var max = 0
        for(i in string.indices){
            var open = 0
            var close = 0
            var j = i
            while(j>=0){
                val char = string[j]
                if(char == '('){
                    open++
                }
                else{
                    close++
                }
                if(open == close){
                    max = Math.max(max, 2*open)
                }
                if(open > close){
                    break
                }
                j--
            }
        }
        return max
    }


}

data class Obj(var longestTillHere: Int = 0, var openBrances: Int = 0)