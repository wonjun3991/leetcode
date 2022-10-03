class Solution {
    fun majorityElement(nums: IntArray): Int {
        val sorted = nums.sorted()
        return sorted[sorted.size/2];
    }
}