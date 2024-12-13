
import java.util.*

class Solution {
    fun findScore(nums: IntArray): Long {
        var ans: Long = 0
        val sorted = Array(nums.size) { IntArray(2) }
        val marked = BooleanArray(nums.size)

        for (i in nums.indices) {
            sorted[i][0] = nums[i]
            sorted[i][1] = i
        }

        Arrays.sort(sorted) { arr1: IntArray, arr2: IntArray ->
            arr1[0] - arr2[0]
        }

        for (i in nums.indices) {
            val number = sorted[i][0]
            val index = sorted[i][1]
            if (!marked[index]) {
                ans += number.toLong()
                marked[index] = true
                if (index - 1 >= 0) {
                    marked[index - 1] = true
                }
                if (index + 1 < nums.size) {
                    marked[index + 1] = true
                }
            }
        }

        return ans
    }
}