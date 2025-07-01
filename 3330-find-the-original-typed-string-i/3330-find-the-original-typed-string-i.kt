class Solution {
    fun possibleStringCount(word: String): Int {
        var count = 1
        for (i in 0..<word.length - 1) {
            if (word[i] == word[i + 1]) {
                count++
            }
        }

        return count
    }
}
