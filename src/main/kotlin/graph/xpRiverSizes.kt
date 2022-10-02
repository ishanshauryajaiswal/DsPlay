package graph

class xpRiverSizes {

    fun riverSizes(matrix: List<List<Int>>): List<Int> {
        val mutableMatrix = ArrayList<ArrayList<Int>>()
        matrix.forEach {
            mutableMatrix.add(it as ArrayList<Int>)
        }
        matrix.flatMap { it.toMutableList() }
        val ans = ArrayList<Int>()
        mutableMatrix.forEach {
            it.forEach{ ele->
                if(ele == 1){
                    ans.add(1+dfs(mutableMatrix.indexOf(it), it.indexOf(ele), mutableMatrix))
                }
            }
        }
        return ans
    }

    private fun dfs(row: Int, col: Int, matrix: ArrayList<ArrayList<Int>>): Int {
        if (row < 0 || row == matrix.size || col < 0 || col == matrix[0].size || matrix[row][col] != 1)
            return 0
        matrix[row][col] = -1
        return (1 +
                dfs(row + 1, col, matrix) +
                dfs(row - 1, col, matrix) +
                dfs(row, col + 1, matrix) +
                dfs(row, col - 1, matrix))
    }
}