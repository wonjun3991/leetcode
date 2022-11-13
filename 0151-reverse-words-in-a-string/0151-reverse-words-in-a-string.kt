class Solution {
    fun reverseWords(s: String): String {
        return s.split(" ")
            .filter { split -> split.isNotEmpty() }
            .reversed()
            .joinToString(" ")
    }
}