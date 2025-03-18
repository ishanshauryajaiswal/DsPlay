package lint.dp

import java.lang.Integer.max

/*
https://www.lintcode.com/problem/125/
 */
class Knapsack {

    fun backPackII(m: Int, a: IntArray, v: IntArray): Int {
        val dp = Array(m+1){IntArray(a.size+1)}
        for(i in 0..m){
            for(j in 0..a.size){
                //NO NEED TO EXPLICITLY SET 0 INDEXES. DO IT IN THE MAIN LOOP
                if(i==0 || j==0)
                    dp[i][j]=0
                else if(i - a[j-1] >= 0){
                    dp[i][j] = max(v[j-1] + dp[i - a[j-1]][j-1], dp[i][j-1])
                }
                else
                    dp[i][j] = dp[i][j-1]
            }
        }
        return dp[m][a.size]
    }

}

/*


nput: arr[] = {40, 20, 30, 10, 30}
Output: 26000
Explanation:There are 4 matrices of dimensions 40×20, 20×30, 30×10, 10×30.

4x2, 2x3, 3x1, 1x3
(AB)(CD)
27
4x3, 3x3
36+27

((AB)C)D
36+12
4x1, 1x3

(A(BC))D
4x2, 2x1, 1x3
6
4x1 1x3
8
12


                            ABCD
                  A   BCD     AB   CD    ABC   D
                   B CD  BC D


           G    E   O   M   E   G
        0  0    0   0   0   0   0
      G    2    2   2   2   2

      E    2    4   4   4

      M    2    4   4   5

      O    2    4   5

      E    2    5

      G    1




 */