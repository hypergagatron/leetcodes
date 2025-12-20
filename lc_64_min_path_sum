// Given Int matrix m x n,find minimum sum of a path from upper left to lower right corner.
// You are allowed to go only right or down in a step.

class Solution {
 
    val minSumCache = hashMapOf<String, Int>()

    fun minPathSum(grid: Array<IntArray>): Int {
        fun minSum(x: Int, y: Int): Int {
            val key = "$x $y"
            if (minSumCache.containsKey(key)) {
                return minSumCache[key]!!
            } else {
                var a = 0
                if (x==0&&y==0) {
                    a = grid[0][0]
                } else if (x == 0) {
                    a = grid[x][y] + minSum(x, y-1)
                } else if (y == 0) {
                    a = grid[x][y] + minSum(x-1, y)
                } else {
                    a = grid[x][y] + Math.min(minSum(x-1,y), minSum(x, y-1))
                }
                minSumCache[key] = a
                return a
            }
        }
        return minSum(grid.size-1, grid[0].size-1)
    }
}
