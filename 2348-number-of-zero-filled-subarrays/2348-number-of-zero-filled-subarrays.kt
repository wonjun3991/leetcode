class Solution {
    fun zeroFilledSubarray(nums: IntArray): Long {
        var result = 0L
        var count = 0
        for (num in nums) {
            if (num == 0) {
                count++
                result += count
            } else{
                count = 0
            }
        }
        
        return result
    }
}
