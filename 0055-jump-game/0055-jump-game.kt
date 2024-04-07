class Solution {
    fun canJump(nums: IntArray): Boolean {
        var backPoint = nums.size - 1
        for(i in nums.size - 2 downTo 0){
            if(i + nums[i] >= backPoint){
                backPoint = i
            }
        }
        return backPoint == 0
    }
}