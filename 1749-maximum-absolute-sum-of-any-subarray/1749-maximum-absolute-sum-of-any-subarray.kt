import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

internal class Solution {
    fun maxAbsoluteSum(nums: IntArray): Int {
        var minPrefixSum = Int.MAX_VALUE
        var maxPrefixSum = Int.MIN_VALUE
        var prefixSum = 0
        var maxAbsSum = 0

        for (i in nums.indices) {
            prefixSum += nums[i]

            minPrefixSum = min(minPrefixSum, prefixSum)
            maxPrefixSum = max(maxPrefixSum, prefixSum)

            if (prefixSum >= 0) {
                maxAbsSum = max(
                    maxAbsSum,
                    max(prefixSum, prefixSum - minPrefixSum)
                )
            } else if (prefixSum <= 0) {
                maxAbsSum = max(
                    maxAbsSum,
                    max(
                        abs(prefixSum),
                        abs(prefixSum - maxPrefixSum)
                    )
                )
            }
        }

        return maxAbsSum
    }
}