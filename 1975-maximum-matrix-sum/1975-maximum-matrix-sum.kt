import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

class Solution {
    fun maxMatrixSum(matrix: Array<IntArray>): Long {
        var sum: Long = 0L
        var negativeCount = 0
        var negativeMinValue: Int = Int.MAX_VALUE

        matrix.forEach { row ->
            row.forEach { column ->
                val absColumn = abs(column)
                sum += absColumn

                negativeMinValue = min(negativeMinValue, absColumn)
                if (column <= 0) {

                    negativeCount++
                }
            }
        }

        if (negativeCount % 2 != 0) {
            sum -= negativeMinValue * 2
        }

        return sum
    }
}