class Solution {
    fun countFairPairs(nums: IntArray, lower: Int, upper: Int): Long {
        val sortedNums = nums.sorted().toIntArray()
        return lowerBound(sortedNums, upper + 1) - lowerBound(sortedNums, lower)
    }

    private fun lowerBound(nums: IntArray, value: Int): Long {
        var left = 0
        var right = nums.size - 1
        var result: Long = 0
        while (left < right) {
            val sum = nums[left] + nums[right]

            if (sum < value) {
                result += (right - left).toLong()
                left++
            } else {
                right--
            }
        }

        return result
    }
}