import kotlin.math.abs

// 연속된 값들의 갯수를 구하는 것
class Solution {
    fun maximumLengthOfRanges(nums: IntArray): IntArray {
        val ans = IntArray(nums.size) { 0 }



        for (i in 0 until nums.size) {
            var left = i
            var right = i
            while (left > 0) {
                if (nums[i] > nums[left - 1]) {
                    left--
                } else {
                    break
                }
            }

            while (right < nums.size -1 ) {
                if (nums[i] > nums[right + 1]) {
                    right++
                } else {
                    break
                }
            }

            ans[i] = right - left + 1 
        }

        return ans
    }
}