import kotlin.math.abs
import kotlin.math.min

class Solution {
    fun maxMatrixSum(matrix: Array<IntArray>): Long {
        var totalSum: Long = 0
        var minAbsVal = Int.MAX_VALUE
        var negativeCount = 0

        for (row in matrix) {
            for (column in row) {
                totalSum += abs(column.toDouble()).toLong()
                if (column < 0) {
                    negativeCount++
                }
                minAbsVal = min(minAbsVal.toDouble(), abs(column.toDouble())).toInt()
            }
        }
        
        if (negativeCount % 2 != 0) {
            totalSum -= (2 * minAbsVal).toLong()
        }

        return totalSum
    }
}