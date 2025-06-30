import kotlin.math.max

class Solution {
    fun findLHS(nums: IntArray): Int {
        val numsToCount = mutableMapOf<Int, Int>()
        for (i in nums) {
            numsToCount.computeIfAbsent(i) { 0 }
            numsToCount[i] = numsToCount.getOrDefault(i, 0) + 1
        }

        var maxNum = 0

        for (i in numsToCount.keys.sorted()) {
            val default = numsToCount.getOrDefault(i, 0)
            maxNum = max(default + numsToCount.getOrDefault(i + 1, -default), maxNum)
        }

        return maxNum
    }
}