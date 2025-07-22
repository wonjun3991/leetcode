import kotlin.math.max

class Solution {
    fun maximumUniqueSubarray(nums: IntArray): Int {
        var sum = 0
        var i = 0
        var j = 0
        val set = mutableSetOf<Int>()
        while (i < nums.size) {
            if (set.contains(nums[i])) {
                while (nums[j] != nums[i]) {
                    set.remove(nums[j])
                    j++
                }
                j++
            }
            set.add(nums[i])
            sum = max(sum, set.sum())

            i++
        }

        return sum
    }
}
