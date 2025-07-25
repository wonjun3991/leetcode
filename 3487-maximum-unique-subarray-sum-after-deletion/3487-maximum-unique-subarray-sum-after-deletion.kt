class Solution {
    fun maxSum(nums: IntArray): Int {
        if(nums.all{ it < 0}){
            return nums.max()
        }
        
        return nums.toSet().filter { it > 0 }.sum()
    } 
}
