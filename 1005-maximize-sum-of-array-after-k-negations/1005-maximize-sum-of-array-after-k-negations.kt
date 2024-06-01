class Solution {
    fun largestSumAfterKNegations(nums: IntArray, k: Int): Int {
        for(i in 0 until k){
            val minValueIndex = nums.indexOf(nums.min())
            nums[minValueIndex] = -nums[minValueIndex]
        }

        return nums.sum()
    }
}
