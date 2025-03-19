class Solution {
    fun minOperations(nums: IntArray): Int {
        var ans = 0

        for(i in 0 until nums.size - 2){
            if(nums[i] == 0){
                nums[i+1] = 1 - nums[i+1]
                nums[i+2] = 1 - nums[i+2]
                ans++
            }
        }
        
        if(nums[nums.size-1] + nums[nums.size-2] != 2){
            return -1
        }
        
        return ans
    }
}