class Solution {
    // Complexity:
    // Time O(N+k^2) and Space O(N) where N is the length of word.
    fun possibleStringCount(
        word: String,
        k: Int,
    ): Int {
        if (word.length < k) {
            return 0
        }
        if (word.length == k) {
            return 1
        }

        val modulo = 1_000_000_007
        val bags = splitAtChanges(word)
        val n = bags.size
        val minBalls = k - n

        if (minBalls <= 0) {
            return productMod(bags, modulo)
        }

        // dp[j]@i := the number of ways to pick j balls from
        // bags[0..=i], except when j equals minBalls it is the number
	    // of ways to pick at least minBalls.
        val dp = LongArray(minBalls + 1)
        dp[0] = 1 // base case i equals -1

        for (i in bags.indices) {
            var wndSum = 0L // Sum of dp[j-bags[i]+1..<j]@i-1

            // Handle the case where j equals minBalls
            dp[minBalls] = (dp[minBalls] * bags[i]) % modulo
            for (j in minBalls - 1 downTo maxOf(0, minBalls - bags[i] + 1)) {
                wndSum = (wndSum + dp[j]) % modulo
                dp[minBalls] = (dp[minBalls] + dp[j] * (j + bags[i] - minBalls)) % modulo
            }

            // Handle the remaining cases
            for (j in minBalls - 1 downTo 0) {
                wndSum = (wndSum - dp[j]).mod(modulo.toLong())

                if (j >= bags[i] - 1) {
                    wndSum = (wndSum + dp[j - bags[i] + 1]) % modulo
                }
                dp[j] = (dp[j] + wndSum) % modulo
            }
        }
        return dp[minBalls].toInt()
    }

    // Returns an array containing the length of each part if we split
    // the word where the character changes.
    private fun splitAtChanges(word: String): IntArray {
        val parts = mutableListOf(1)
        for (i in 1..<word.length) {
            if (word[i] != word[i - 1]) {
                parts.add(1)
            } else {
                parts[parts.lastIndex]++
            }
        }
        return parts.toIntArray()
    }

    // Returns the product of elements mod modulo.
    private fun productMod(
        nums: IntArray,
        modulo: Int,
    ): Int {
        var result = 1L
        for (num in nums) {
            result = (result * num) % modulo
        }
        return result.toInt()
    }
}