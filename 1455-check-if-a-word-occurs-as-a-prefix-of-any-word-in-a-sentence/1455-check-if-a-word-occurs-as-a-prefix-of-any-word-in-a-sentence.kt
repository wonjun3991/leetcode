class Solution {
    fun isPrefixOfWord(sentence: String, searchWord: String): Int {
        val indexOfPrefixWord = sentence.split(" ").indexOfFirst { it.startsWith(searchWord) }
        if (indexOfPrefixWord == -1) return indexOfPrefixWord
        return indexOfPrefixWord + 1
    }
}