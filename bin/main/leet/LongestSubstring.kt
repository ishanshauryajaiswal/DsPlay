package leet

import java.lang.Integer.max
import java.util.*
import kotlin.Comparator
import kotlin.collections.HashMap

class LongestSubstring {
    /*
    abcabcbb
     */

    fun lengthOfLongestSubstring(s: String): Int {
        val map = HashMap<Char, Int>()
        var max = 0
        var curr = 0
        var start = 0
        for(i in 0..s.length){
            val char = s[i]
            if(map.containsKey(char) && map[char]!! > start){
                curr = i - map[char]!!
                start = map[char]!! + 1
            }
            else {
                curr++
                max = max(max, curr)
            }
            map[char] = i
        }
        return max
    }

    fun lengthOfLongestSubstring2(s: String): String {
        val dp = IntArray(128){-1}
        var max = 0
        var curr = 0
        var start = 0
        var startIndexAns = 0
        var endIndexAns = 0
        for(i in 0..s.length){
            val char = s[i]
            val asciiValue = char.toInt()
            if(dp[asciiValue] >= start){
                curr = i - dp[asciiValue]
                start = dp[asciiValue] + 1
            }
            curr = i - start
            dp[asciiValue] = i
            if(curr > max){
                startIndexAns = start
                endIndexAns = i
                max = curr
            }
        }
        val minHeap = PriorityQueue<Pair<Int, Int>>(object: Comparator<Pair<Int, Int>>{
            override fun compare(o1: Pair<Int, Int>, o2: Pair<Int, Int>): Int {
                return o1.first - o2.first
            }

        })
        return s.substring(startIndexAns, endIndexAns)
    }
}