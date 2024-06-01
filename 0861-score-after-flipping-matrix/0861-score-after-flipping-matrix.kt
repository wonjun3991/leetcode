import kotlin.math.abs

class Solution {
    fun matrixScore(grid: Array<IntArray>): Int {
        val height = grid.size
        val width = grid[0].size
        // 가로로 먼저 뒤집고
        for (i in 0 until height) {
            if (grid[i][0] == 0) {
                for (l in 0 until width) {
                    grid[i][l] = abs(grid[i][l] - 1)
                }
            }
        }

        // 세로로 뒤집고
        for (w in 0 until width) {
            var zeroCount = 0
            for (h in 0 until height) {
                if (grid[h][w] == 0) {
                    zeroCount++
                }
            }

            if (zeroCount > height - zeroCount) {
                for (h in 0 until height) {
                    grid[h][w] = abs(grid[h][w] - 1)
                }
            }
        }
        // 합 계산
        var score = 0
        for (i in 0 until height) {
            for (l in 0 until width) {
                score += grid[i][l] shl (width - 1 - l)
            }
        }



        return score
    }
}
