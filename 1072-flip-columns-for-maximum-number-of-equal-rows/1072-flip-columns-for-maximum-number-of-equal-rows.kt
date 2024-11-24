
import kotlin.math.max

class Solution {
    fun maxEqualRowsAfterFlips(matrix: Array<IntArray>): Int {
        val patternFrequency: MutableMap<String, Int> = HashMap()

        for (currentRow in matrix) {
            val patternBuilder = StringBuilder("")

            for (col in currentRow.indices) {
                if (currentRow[0] == currentRow[col]) {
                    patternBuilder.append("T")
                } else {
                    patternBuilder.append("F")
                }
            }

            val rowPattern = patternBuilder.toString()
            patternFrequency[rowPattern] = patternFrequency.getOrDefault(rowPattern, 0) + 1
        }
        
        var maxFrequency = 0
        for (frequency in patternFrequency.values) {
            maxFrequency = max(frequency.toDouble(), maxFrequency.toDouble()).toInt()
        }

        return maxFrequency
    }
}