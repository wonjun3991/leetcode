class Solution {
    fun prefixCount(words: Array<String>, pref: String) = words.count { word -> word.startsWith(pref) }
}