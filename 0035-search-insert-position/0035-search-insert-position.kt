class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var output = 0
        for((index, value) in nums.withIndex()){
            if(target <= value){
                break
            }
            output = index + 1
        }
        
        return output
    }
}