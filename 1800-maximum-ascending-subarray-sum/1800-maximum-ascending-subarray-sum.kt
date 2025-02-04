class Solution {
    fun maxAscendingSum(nums: IntArray): Int {
        var max = nums[0]
        var increasing = nums[0]

        for(i in 1 until nums.size){
            if(nums[i] > nums[i-1]){
                increasing += nums[i]

            } else{
                increasing = nums[i]
            }

            max = maxOf(increasing, max)
        }
        return max
    }
}