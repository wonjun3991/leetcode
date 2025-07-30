import kotlin.math.max

class Solution {
    fun longestSubarray(nums: IntArray): Int {
        val maximum = nums.max()
        var longest = 0
        var count = 0
        for (i in nums.indices) {
            if (nums[i] == maximum) {
                count++
            }
            if (nums[i] != maximum) {
                longest = max(longest, count)
                count = 0
            }
        }
        longest = max(longest, count)

        return longest
    }
}
