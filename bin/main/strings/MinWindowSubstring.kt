package strings

import java.util.*
import kotlin.Comparator
import kotlin.collections.HashMap

class MinWindowSubstring {

    fun minWindow(s1: String, s2: String): String {
        var start = 0
        var matched = 0
        var minLength = Integer.MAX_VALUE
        val sizeS1 = s1.length
        val sizeS2 = s2.length
        val map = createMap(s2)
        var ansStart = 0
        var ansEnd = 0
        for (i in 0 until sizeS1) {
            val charS1 = s1[i]
            if (map.containsKey(charS1)) {
                if (map[charS1]!! > 0) {
                    matched++
                }
                map[charS1] = map[charS1]!! - 1

                while (matched == sizeS2) {
                    if (minLength > 1 + i - start) {
                        minLength = 1 + i - start
                        ansStart = start
                        ansEnd = i+1
                    }
                    val char2 = s1[start]
                    if (!map.containsKey(char2)) {
                        start++
                    } else if (map[char2]!! < 0) {
                        start++
                        map[char2] = map[char2]!! + 1
                    }
                    else
                        break
                }
            }
        }
        val q = PriorityQueue(object : Comparator<Node>{
            override fun compare(o1: Node, o2: Node): Int {
                return o1.`val`
            }

        })
        return s1.substring(ansStart, ansEnd)
    }

    data class Node(var `val`: Int)

    fun createMap(s: String): HashMap<Char, Int>{
        val hashMap = HashMap<Char, Int>()
        s.forEach{
            hashMap[it] = hashMap.getOrDefault(it, 0) + 1
        }
        return hashMap
    }

}
