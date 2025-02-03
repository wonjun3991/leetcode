class Solution {
    fun longestMonotonicSubarray(nums: IntArray): Int {
        var max = 1
        var increasing = 1
        var decreasing = 1

        for(i in 1 until nums.size){
            if(nums[i] > nums[i-1]){
                decreasing = 1
                increasing++

            } else if(nums[i] < nums[i-1]){
                decreasing++
                increasing = 1

            } else{
                increasing = 1
                decreasing = 1
            }

            max = maxOf(increasing, decreasing, max)
        }
        return max
    }
}