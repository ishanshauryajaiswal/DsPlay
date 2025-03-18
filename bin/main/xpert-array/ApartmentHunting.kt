package `xpert-array`

import java.lang.Integer.max
import kotlin.math.abs

class ApartmentHunting {

    fun apartmentHunting(blocks: List<Map<String, Boolean>>, reqs: List<String>): Int {
        // Write your code here.
        var ans = -1
        val size = blocks.size
        val auxList = clone(blocks, reqs)
        var min = Int.MAX_VALUE
        auxList.forEach outer@{ block ->
            val index = auxList.indexOf(block)
            checkFront(block, auxList, index, size)
            checkRear(block, auxList, index, size)
            var flag = true
            var tempMin = Int.MAX_VALUE
            var tempMax = -1
            block.forEach{
                if(it.value == null) {
                    flag = false
                    tempMin = Int.MAX_VALUE
                    tempMax = -1
                    return@outer
                }
                else{
                    val a = abs(it.value!! - index)
                    tempMax = max(tempMax, a)
                }
            }
            if(flag && tempMax < min){
                min = tempMax
                ans = index
            }
        }
        return ans
    }

    fun clone(list: List<Map<String, Boolean>>, reqs: List<String>): List<MutableMap<String, Int?>> {
        return list.map { block ->
            block.filter { reqs.contains(it.key) }.mapValues {
                if (it.value)
                    list.indexOf(block)
                else
                    null
            }.toMutableMap()
        }
    }

    fun checkFront(block: MutableMap<String, Int?>, list: List<MutableMap<String, Int?>>, i: Int, size: Int): MutableMap<String, Int?> {
        var index = i+1
        while (index < size){
            val tempBlock = list[index]
            block.forEach{
                val nearestValue = tempBlock[it.key]
                if(nearestValue != null){
                    if(it.value == null){
                        block[it.key] = nearestValue
                    }
                    else{
                        block[it.key] = if(abs(index - it.value!!) < abs(index - nearestValue)){
                            it.value
                        }
                        else{
                            nearestValue
                        }
                        return@forEach
                    }
                }
            }
            var flag = true
            block.forEach{
                if(it.value == null)
                    flag = false
            }
            if(flag)
                return block
            index++

        }
        return block
    }

    fun checkRear(block: MutableMap<String, Int?>, list: List<MutableMap<String, Int?>>, i: Int, size: Int): MutableMap<String, Int?> {
        var index = i-1
        while (index >= 0){
            val tempBlock = list[index]
            block.forEach{
                val nearestValue = tempBlock[it.key]
                if(nearestValue != null){
                    if(it.value == null){
                        block[it.key] = nearestValue
                    }
                    else{
                        block[it.key] = if(abs(index - it.value!!) < abs(index - nearestValue)){
                            it.value
                        }
                        else{
                            nearestValue
                        }
                        return@forEach
                    }
                }
            }
            var flag = true
            block.forEach{
                if(it.value == null)
                    flag = false
            }
            if(flag)
                return block
            index++

        }
        return block
    }
    /*
        0,  1,  2,  3,  4
    g   1   1   2   2   2
    sc  0   0   2   3   4
    st  4   4   4   4   4

     */

    fun apartmentHuntingg(blocks: List<Map<String, Boolean>>, reqs: List<String>): Int {
        blocks.forEach { map ->
            map.filterKeys { reqs.contains(it) }
        }
        val dp = Array(reqs.size){Array(blocks.size){0} }
        for(i in reqs.indices){
            var closest = -1
            for(j in blocks.indices){
                if(blocks[j].get(reqs[i]) == true){
                    closest = j
                }
                dp[i][j] = closest
            }
            closest = -1
            for(j in blocks.indices.reversed()){
                if(blocks[j].get(reqs[i]) == true){
                    closest = j
                }
                if(closest != -1){
                    val temp = dp[i][j]
                    if(temp != -1){
                        if(abs(closest - j) < abs(temp - j)){
                            dp[i][j] = closest
                        }
                    }
                    else{
                        dp[i][j] = closest
                    }
                }
            }
        }
        var ans = Int.MAX_VALUE
        var sol = -1
        outer@ for(i in blocks.indices){
            var max = -1
            inner@for(j in reqs.indices){
                if(dp[j][i] == -1) {
                    continue@outer
                }
                max = max(max, abs(dp[j][i] - i))
            }
            if(max < ans){
                ans = max
                sol = i
            }
        }
        return sol
    }
}