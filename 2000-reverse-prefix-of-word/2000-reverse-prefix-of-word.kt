class Solution {
    fun reversePrefix(word: String, ch: Char): String {
        val index = word.indexOf(ch)
        return word.substring(0, index + 1).reversed() + word.substring(index + 1)
    }
}
