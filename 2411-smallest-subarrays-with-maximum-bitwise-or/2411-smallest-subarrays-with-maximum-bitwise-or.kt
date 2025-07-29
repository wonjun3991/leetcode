class Solution {
    fun smallestSubarrays(nums: IntArray): IntArray {
        val maximum = nums.reduce { acc, i -> acc.or(i) }
        return nums
            .mapIndexed { index, i ->
                var max = i
                var count = 1

                for (j in index until nums.size) {
                    val new = max.or(nums[j])
                    if (new > max) {
                        max = new
                        count = j - index + 1
                    }
                    if(new == maximum){
                        break
                    }
                }

                return@mapIndexed count
            }.toIntArray()
    }
}
