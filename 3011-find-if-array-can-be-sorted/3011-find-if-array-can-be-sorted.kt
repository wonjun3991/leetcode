internal class Solution {
    fun canSortArray(nums: IntArray): Boolean {
        // Avoid modifying the input directly
        val values = nums.copyOf(nums.size)

        val n = values.size

        for (i in 0 until n) {
            for (j in 0 until n - i - 1) {
                if (values[j] <= values[j + 1]) {
                    // No swap needed
                    continue
                } else {
                    if (Integer.bitCount(values[j]) ==
                        Integer.bitCount(values[j + 1])
                    ) {
                        // Swap the elements
                        val temp = values[j]
                        values[j] = values[j + 1]
                        values[j + 1] = temp
                    } else {
                        return false
                    }
                }
            }
        }
        return true
    }
}