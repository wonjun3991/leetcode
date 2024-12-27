import kotlin.math.max

class Solution {
    fun maxScoreSightseeingPair(values: IntArray): Int {
        // values[i] + i + values[j]  - j
        val size = values.size
        var leftMaxScore = values[0]

        var maxScore = 0

        for ( i in 1 until size){
            val rightMaxScore = values[i] - i
            maxScore = max(maxScore, leftMaxScore + rightMaxScore)

            leftMaxScore = max(leftMaxScore, values[i] + i)
        }
        
        return maxScore
    }
}
