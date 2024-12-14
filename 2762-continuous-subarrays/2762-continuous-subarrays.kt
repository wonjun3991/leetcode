import java.util.*

class Solution {
    fun continuousSubarrays(nums: IntArray): Long {
        val freq = TreeMap<Int, Int>()
        var left = 0
        var right = 0
        val n = nums.size
        var count: Long = 0

        while (right < n) {
            freq[nums[right]] = freq.getOrDefault(nums[right], 0) + 1
            while (freq.lastEntry().key - freq.firstEntry().key > 2) {

                freq[nums[left]] = freq[nums[left]]!! - 1
                if (freq[nums[left]] == 0) {
                    freq.remove(nums[left])
                }
                left++
            }

            count += (right - left + 1).toLong()
            right++
        }

        return count
    }
}