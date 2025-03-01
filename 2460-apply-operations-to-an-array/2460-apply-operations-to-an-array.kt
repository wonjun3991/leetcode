class Solution {
    fun applyOperations(nums: IntArray): IntArray {
        val n = nums.size
        val modifiedNums = IntArray(n)
        var zeroCount = 0

        for (index in 0 until n - 1) {
            if (nums[index] == nums[index + 1] && nums[index] != 0) {
                nums[index] *= 2
                nums[index + 1] = 0
            }
        }


        for (num in nums) {
            if (num != 0) {
                modifiedNums[zeroCount++] = num
            }
        }
        
        while (zeroCount < n) {
            modifiedNums[zeroCount++] = 0
        }

        return modifiedNums
    }
}