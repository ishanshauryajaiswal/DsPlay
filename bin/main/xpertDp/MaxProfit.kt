package xpertDp


class MaxProfit {
    fun maxProfitWithKTransactions(prices: List<Int>, k: Int): Int {
        val size = prices.size
        if(size == 0) return 0
        val dp = Array(k){ Array(size){Pair(0, true)}}
        fillTopRow(prices, dp)

        for (i in 1 until k){
            for(j in size-2 downTo 0){
                val buyPrice = prices[j]
                var max = dp[i][j+1].first
                for(m in j+1 until size){
                    if(dp[i-1][m].second){
                        val profit = dp[i-1][m].first + (prices[m] - buyPrice)
                        if(profit > max){
                            max = profit
                            dp[i][j] = Pair(max, false)
                        } } }
                if(dp[i][j].second){
                    dp[i][j] = Pair(max, true)
                } } }
        return dp[k-1][0].first
    }
    private fun fillTopRow(prices: List<Int>, dp: Array<Array<Pair<Int, Boolean>>>){
        var maxPrice = 0
        var maxProfit = 0
        for(i in prices.indices.reversed()){
            val price = prices[i]
            if(maxPrice < price){
                maxPrice = price
            }
            if(maxPrice - price > maxProfit){
                maxProfit = maxPrice - price
                dp[0][i] = Pair(maxProfit, false)
            }
            else{
                dp[0][i] = Pair(maxProfit, true)
            } } } }


fun maxProfitWithKTransactionsOneD(prices: List<Int>, k: Int): Int {
    val size = prices.size
    if(size == 0) return 0
    val dp = Array(size){Pair(0, true)}
    fillTopRowOneD(prices, dp)

    for (i in 2..k){
        for(j in size-2 downTo 0){
            val buyPrice = prices[j]
            var max = dp[j+1].first
            dp[j] = Pair(dp[j+1].first, true)
            for(m in j+1 until size){
                if(dp[m].second){
                    val profit = dp[m].first + (prices[m] - buyPrice)
                    if(profit > max){
                        max = profit
                        dp[j] = Pair(max, false)
                    } } }
            if(dp[j].second){
                dp[j] = Pair(max, true)
            } } }
    return dp[0].first
}

fun fillTopRowOneD(prices: List<Int>, dp: Array<Pair<Int, Boolean>>) {
    var maxPrice = 0
    var maxProfit = 0
    for (i in prices.indices.reversed()) {
        val price = prices[i]
        if (maxPrice < price) {
            maxPrice = price
        }
        if (maxPrice - price > maxProfit) {
            maxProfit = maxPrice - price
            dp[i] = Pair(maxProfit, false)
        } else {
            dp[i] = Pair(maxProfit, true)
        }
    }
}