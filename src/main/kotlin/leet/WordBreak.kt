package leet

class WordBreak {

    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val size = s.length
        val dp = BooleanArray(size+1)
        dp[0] = true
        val dict = wordDict.toSet()
        for(i in 0 until size){
            var k = 0
            var temp: String = ""
            while(i-k >=0 && k<=20){
                val char = s[i-k]
                temp =  char+temp
                if(dp[i-k] && dict.contains(temp)){
                    dp[i+1] = true
                    break
                }
                k++
            }
        }
        return dp[size]
    }
}