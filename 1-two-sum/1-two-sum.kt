class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val numsCount = nums.count()
        for (first in 0 until numsCount) {
            for (second in first + 1 until numsCount) {
                var sum = nums[first] + nums[second]
                if( sum== target){
                    return intArrayOf(first, second)
                }
            }
        }
        return intArrayOf(0, 0)
    }
}