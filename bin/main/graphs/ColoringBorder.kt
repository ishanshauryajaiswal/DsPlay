package graphs

import java.util.*
import kotlin.collections.HashMap


/*
https://leetcode.com/problems/coloring-a-border/
 */
class ColoringBorder {

    fun colorBorder(grid: Array<IntArray>, row: Int, col: Int, color: Int): Array<IntArray> {
        if (grid.isEmpty())
            return grid
        val originalColor = grid[row][col]
        val visited = Array(grid.size) { BooleanArray(grid[0].size) { false } }
        val marked = Array(grid.size) { BooleanArray(grid[0].size) { false } }
        dfsForConnectedComponents(grid, row, col, originalColor, color, visited, marked)
        return grid
    }

    private fun dfsForConnectedComponents(
        grid: Array<IntArray>,
        row: Int,
        col: Int,
        originalColor: Int,
        color: Int,
        visited: Array<BooleanArray>,
        marked: Array<BooleanArray>
    ) {
        if (row < 0 || col < 0 || row == grid.size || col == grid[0].size || grid[row][col] != originalColor || visited[row][col])
            return
        visited[row][col] = true
        if (checkAdjacentForSameColor(grid, row, col, originalColor, visited))
            grid[row][col] = color
        dfsForConnectedComponents(grid, row + 1, col, originalColor, color, visited, marked)
        dfsForConnectedComponents(grid, row - 1, col, originalColor, color, visited, marked)
        dfsForConnectedComponents(grid, row, col + 1, originalColor, color, visited, marked)
        dfsForConnectedComponents(grid, row, col - 1, originalColor, color, visited, marked)
    }

    private fun checkAdjacentForSameColor(
        grid: Array<IntArray>,
        row: Int,
        col: Int,
        originalColor: Int,
        visited: Array<BooleanArray>
    ): Boolean {
        if (row == grid.size - 1 || col == grid[0].size - 1 || row == 0 || col == 0)
            return true
        if ((visited[row + 1][col] || grid[row + 1][col] == originalColor) &&
            (visited[row - 1][col] || grid[row - 1][col] == originalColor) &&
            (visited[row][col + 1] || grid[row][col + 1] == originalColor) &&
            (visited[row][col - 1] || grid[row][col - 1] == originalColor)
        )
            return false
        return true
    }

    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        val map = HashMap<Char, Char>()
        map['{'] = '}'
        map['('] = ')'
        map['['] = ']'
        s.forEach {
            if (map.keys.contains(it))
                stack.push(it)
            else{
                if(map[stack.peek()] != it)
                    return false
                stack.pop()
            }
        }
        return true

    }

}