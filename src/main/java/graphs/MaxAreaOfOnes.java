package graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MaxAreaOfOnes {

    int max = 0;
    public int findMaxArea(int[][] grid)
    {
        if(grid.length == 0)
            return max;
        int row = grid.length; int col = grid[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                dfsUtil(i, j, grid, row, col);
            }
        }
        return max;
    }

    public int dfsUtil(int i, int j, int[][] grid, int row, int col){
        if(i < 0 || i == row || j < 0 || j == col || grid[i][j] != 1)
            return 0;
        grid[i][j] = -1;
        int count = 1 +
                dfsUtil(i-1, j, grid, row, col) +
                dfsUtil(i-1, j+1, grid, row, col) +
                dfsUtil(i, j+1, grid, row, col) +
                dfsUtil(i+1, j+1, grid, row, col) +
                dfsUtil(i+1, j, grid, row, col) +
                dfsUtil(i+1, j-1, grid, row, col) +
                dfsUtil(i, j-1, grid, row, col) +
                dfsUtil(i-1, j-1, grid, row, col);
        max = Math.max(max, count);
        return count;
    }

    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList<Integer> ans = new ArrayList();
        subSetUtil(arr, 0, ans, N, 0);
        return ans;
    }

    private boolean subSetUtil(ArrayList<Integer> arr, int i, ArrayList<Integer> ans, int size, int sum){
        if(i==size)
            ans.add(sum);
        else
            return subSetUtil(arr, i+1, ans, size, sum) && subSetUtil(arr, i+1, ans, size, sum+arr.get(i));
        return true;
    }

}
