import kotlin.math.max

class Solution {
    fun maximumBeauty(nums: IntArray, k: Int): Int {
        val sortedNums = nums.sorted()
        var end = 0
        var max = 0

        for (start in 0 until sortedNums.size) {
            while (end < sortedNums.size && sortedNums[end] - sortedNums[start] <= 2 * k) {
                end++
            }
            max = max(max, end - start)
        }
        return max
    }
}