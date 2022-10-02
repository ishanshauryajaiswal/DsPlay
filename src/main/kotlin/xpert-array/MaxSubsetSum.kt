package `xpert-array`

import java.lang.Integer.max


//pooDp

class MaxSubsetSum {

    fun maxSubsetSumNoAdjacent(array: List<Int>): Int {
        var ans = -1
        val size = array.size
        val dp = Array(size+1){ Pair(0,0) }
        for(i in size-1 downTo 0){
            val incl = array[i] + dp[i+1].second
            val excl = max(dp[i+1].first, dp[i+1].second)
            ans = max(incl, excl)
            dp[i] = Pair(incl, excl)
        }
        return ans
    }


}