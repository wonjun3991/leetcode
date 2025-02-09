class Solution {
    fun countBadPairs(nums: IntArray): Long {
        var count = 0L
        val differenceCount = hashMapOf<Int, Int>()
        for (i in nums.indices) {
            val diff = nums[i] - i
            val goodPairCount = differenceCount.getOrDefault(diff, 0)
            
            count = count + i - goodPairCount
                
            differenceCount[diff] = goodPairCount + 1
        }
        return count
    }
}