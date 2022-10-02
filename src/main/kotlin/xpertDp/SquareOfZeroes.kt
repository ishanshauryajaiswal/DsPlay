package xpertDp

class SquareOfZeroes {

    fun squareOfZeroes(matrix: List<List<Int>>): Boolean {
        val row = matrix.size
        if(row == 0)
            return false
        val col = matrix[0].size
        val dp = Array(row){Array(col){Pair(0,0)} }
        for(i in 0 until row){
            var runningZeroes = 0
            for(j in 0 until col){
                if(matrix[i][j] == 1){
                    runningZeroes = 0
                }
                else{
                    runningZeroes++
                }
                dp[i][j] = Pair(runningZeroes, 0)
            }
        }

        for(i in 0 until col){
            var runningZeroes = 0
            for(j in 0 until row){
                if(matrix[i][j] == 1){
                    runningZeroes = 0
                }
                else{
                    runningZeroes++
                }
                dp[i][j] = Pair(dp[i][j].first, runningZeroes)
            }
        }

        return false
    }


}