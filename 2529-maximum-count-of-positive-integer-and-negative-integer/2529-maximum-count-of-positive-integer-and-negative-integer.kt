import kotlin.math.max

class Solution {
    fun maximumCount(nums: IntArray): Int {
        var negativeCount = 0
        var positiveCount = 0

        nums.forEach {
            if (it > 0) {
                positiveCount++
            }
            if (it < 0) {
                negativeCount++
            }
        }

        return max(positiveCount, negativeCount)
    }
}