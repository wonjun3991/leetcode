class Solution {
    fun longestNiceSubarray(nums: IntArray): Int {
        // Binary search for the longest nice subarray length
        var left = 0
        var right = nums.size
        var result = 1 // Minimum answer is 1 (as subarrays of length 1 are always nice)

        while (left <= right) {
            val length = left + (right - left) / 2
            if (canFormNiceSubarray(length, nums)) {
                result = length // Update the result
                left = length + 1 // Try to find a longer subarray
            } else {
                right = length - 1 // Try a shorter length
            }
        }
        return result
    }

    private fun canFormNiceSubarray(length: Int, nums: IntArray): Boolean {
        if (length <= 1) return true // Subarray of length 1 is always nice


        // Try each possible starting position for subarray of given length
        for (start in 0..nums.size - length) {
            var bitMask = 0 // Tracks the bits used in the current subarray
            var isNice = true

            // Check if the subarray starting at 'start' with 'length' elements is nice
            for (pos in start until start + length) {
                // If current number shares any bits with existing mask,
                // the subarray is not nice
                if ((bitMask and nums[pos]) != 0) {
                    isNice = false
                    break
                }
                bitMask = bitMask or nums[pos] // Add current number's bits to the mask
            }

            if (isNice) return true // Found a nice subarray of the specified length
        }
        return false // No nice subarray of the given length exists
    }
}