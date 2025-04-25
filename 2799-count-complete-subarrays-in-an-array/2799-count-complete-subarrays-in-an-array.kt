class Solution {
    fun countCompleteSubarrays(nums: IntArray): Int {
        val numsDistinctCount = nums.distinct().count()
        var count = 0
        val numberToCount = mutableMapOf<Int, Int>()
        var right= 0
        for(left in 0 until nums.size){
            while(numberToCount.keys.count() < numsDistinctCount && right < nums.size){
                numberToCount[nums[right]] = numberToCount.getOrDefault(nums[right], 0) + 1
                right++
            }

            if(numberToCount.keys.count() == numsDistinctCount){
                count++

                count = count + nums.size - right
            }

            println(numberToCount)

            numberToCount[nums[left]] = numberToCount[nums[left]]!! - 1
            if(numberToCount[nums[left]]!! <=0 ){
                numberToCount.remove(nums[left])
            }
        }

        return count
    }
}