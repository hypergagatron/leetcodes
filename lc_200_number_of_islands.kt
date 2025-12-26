/**
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
*/
class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        var count = 0

        fun fn(i: Int,j: Int): List<Pair<Int,Int>> {
            val n = mutableListOf<Pair<Int,Int>>()
            if (i-1 in 0..grid.size-1 && j in 0..grid[0].size-1 && grid[i-1][j] == '1') {
                n.add(Pair(i-1, j))
            }

            if (i+1 in 0..grid.size-1 && j in 0..grid[0].size-1 && grid[i+1][j] == '1') {
                n.add(Pair(i+1, j))
            }

            if (i in 0..grid.size-1 && j-1 in 0..grid[0].size-1 && grid[i][j-1] == '1') {
                n.add(Pair(i, j-1))
            }

            if (i in 0..grid.size-1 && j+1 in 0..grid[0].size-1 && grid[i][j+1] == '1') {
                n.add(Pair(i, j+1))
            }
            return n
        }

        fun markIsland(i: Int, j: Int) {
            grid[i][j] = 'x'
            val neighbours = fn(i,j)
            println(neighbours)
            for (n in neighbours) {
                markIsland(n.first, n.second)
            }
        }

        for (i in 0..grid.size-1) {
            for (j in 0..grid[0].size-1) {
                if (grid[i][j] == '1') {
                    markIsland(i,j)
                    count++
                }
            }
        }

        return count
    }
}
