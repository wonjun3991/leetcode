import kotlin.math.max
import kotlin.math.min

class Solution {
    fun minimumArea(grid: Array<IntArray>): Int {
        var minCol = Int.MAX_VALUE
        var maxCol = Int.MIN_VALUE
        var minRow = Int.MAX_VALUE
        var maxRow = Int.MIN_VALUE

        grid.forEachIndexed { rowIndex, rows ->
            rows.forEachIndexed { colIndex, col ->
                if (col == 1) {
                    minCol = min(minCol, colIndex)
                    maxCol = max(maxCol, colIndex)
                    minRow = min(minRow, rowIndex)
                    maxRow = max(maxRow, rowIndex)
                }
            }
        }

        return (maxCol - minCol + 1) * (maxRow - minRow + 1)
    }
}
