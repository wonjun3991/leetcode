internal class Solution {
    fun minChanges(s: String): Int {
        var currentChar = s.first()

        var consecutiveCount = 0
        var minChangesRequired = 0

        for (i in s.indices) {
            if (s[i] == currentChar) {
                consecutiveCount++
                continue
            }

            // If we have even count of characters, start new sequence
            if (consecutiveCount % 2 == 0) {
                consecutiveCount = 1
            } else {
                consecutiveCount = 0
                minChangesRequired++
            }

            currentChar = s[i]
        }

        return minChangesRequired
    }
}