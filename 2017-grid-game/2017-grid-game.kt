import kotlin.math.max
import kotlin.math.min

class Solution {
    fun gridGame(grid: Array<IntArray>): Long {
        var firstRowSum: Long = 0
        for (num in grid[0]) {
            firstRowSum += num.toLong()
        }
        var secondRowSum: Long = 0
        var minimumSum = Long.MAX_VALUE
        for (turnIndex in grid[0].indices) {
            firstRowSum -= grid[0][turnIndex]
            minimumSum = min(
                minimumSum,
                max(firstRowSum, secondRowSum)
            )
            secondRowSum += grid[1][turnIndex]
        }
        return minimumSum
    }
}