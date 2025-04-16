class Solution {
    fun countGood(nums: IntArray, k: Int): Long {
        val n = nums.size
        var same = 0
        var right = -1
        val numberToCount = HashMap<Int, Int>()
        var ans = 0L
        for (left in nums.indices) {
            while (same < k && right + 1 < n) {
                right++
                same += numberToCount.getOrDefault(nums[right], 0)
                numberToCount[nums[right]] = numberToCount.getOrDefault(nums[right], 0) + 1
            }
            if (same >= k) {
                ans += n - right
            }
            numberToCount[nums[left]] = numberToCount[nums[left]]!! - 1
            same -= numberToCount[nums[left]]!!
        }
        return ans
    }
}