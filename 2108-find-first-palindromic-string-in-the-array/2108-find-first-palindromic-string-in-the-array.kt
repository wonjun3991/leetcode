class Solution {
    fun firstPalindrome(words: Array<String>): String {
        val palindromes = words.filter { it == it.reversed() }
        return palindromes.firstOrNull() ?: ""
    }
}