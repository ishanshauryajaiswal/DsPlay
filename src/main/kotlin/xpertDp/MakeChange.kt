package `xpert-dp`

class MakeChange {

    fun numberOfWaysToMakeChange(n: Int, denominations: List<Int>): Int {
        val dp = Array(n+1){ IntArray(denominations.size){0} }
        dp[0].fill(1)
        for(i in 1..n){
            for(j in denominations.indices){
                val tempVariable = i - denominations[j]
                if(tempVariable >= 0){
                    if(j == 0){
                        dp[i][j] = dp[tempVariable][j]
                    }
                    else{
                        dp[i][j] = dp[i][j-1] + dp[tempVariable][j]
                    }
                }
                else{
                    if(j > 0)
                        dp[i][j] = dp[i][j-1]
                }
            }
        }
        return dp[n][denominations.size-1]
    }



}