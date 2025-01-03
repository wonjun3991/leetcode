class Solution {
    fun waysToSplitArray(nums: IntArray): Int {
        val prefixSum = LongArray(nums.size)
        nums.forEachIndexed { index, i ->
            prefixSum[index] = i + if (index == 0) 0 else prefixSum[index - 1]
        }

        var count = 0

        for(i in 0 until nums.size - 1){
            if(prefixSum[i] >= prefixSum[nums.size-1] - prefixSum[i]){
                count++
            }
        }

        return count
    }
}