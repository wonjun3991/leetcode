class Solution {
    private fun swap (first: Int, second: Int, nums: IntArray) {
        val temp = nums[first]
        nums[first] = nums[second]
        nums[second] = temp
    }
    
    fun moveZeroes(nums: IntArray): Unit {
        var first = 0
        var second = 0
        
        val numsSize = nums.size
        
        while (first < numsSize) {
            if (nums[first] != 0) {
                swap(first, second, nums)
                second++
            }
            
            first++
        }
    }

}