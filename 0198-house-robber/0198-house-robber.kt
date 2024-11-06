import kotlin.math.max

class Solution {
    fun rob(nums: IntArray): Int {
        val N = nums.size

        if (N == 0) {
            return 0
        }

        val maxRobbedAmount = IntArray(nums.size + 1)

        maxRobbedAmount[N] = 0
        maxRobbedAmount[N - 1] = nums[N - 1]

        for (i in N - 2 downTo 0) {
            maxRobbedAmount[i] = max(
                maxRobbedAmount[i + 1],
                maxRobbedAmount[i + 2] + nums[i]
            )
        }
        return maxRobbedAmount[0]
    }
}