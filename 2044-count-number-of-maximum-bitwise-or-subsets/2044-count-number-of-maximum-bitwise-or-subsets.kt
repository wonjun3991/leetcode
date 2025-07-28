class Solution {
    fun countMaxOrSubsets(nums: IntArray): Int {
        var maxOrValue = 0
        for (num in nums) {
            maxOrValue = maxOrValue.or(num)
        }
        return countSubsets(nums, 0, 0, maxOrValue)
    }

    private fun countSubsets(
        nums: IntArray,
        index: Int,
        currentOr: Int,
        targetOr: Int,
    ): Int {
        // Base case: reached the end of the array
        if (index == nums.size) {
            return if (currentOr == targetOr) 1 else 0
        }

        // Don't include the current number
        val countWithout = countSubsets(nums, index + 1, currentOr, targetOr)

        // Include the current number
        val countWith =
            countSubsets(
                nums,
                index + 1,
                currentOr.or(nums[index]),
                targetOr,
            )

        // Return the sum of both cases
        return countWithout + countWith
    }
}
