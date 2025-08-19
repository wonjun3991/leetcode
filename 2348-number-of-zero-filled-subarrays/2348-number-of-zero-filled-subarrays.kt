class Solution {
    fun zeroFilledSubarray(nums: IntArray): Long {
        var result = 0L
        var count = 0L
        nums.fold(count) { acc, i ->
            if (i == 0) {
                count += 1
            } else {
                result += count * (count + 1) / 2
                count = 0
            }

            return@fold count
        }
        result += count * (count + 1) / 2

        return result
    }
}
