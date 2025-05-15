class Solution {
    fun getLongestSubsequence(words: Array<String>, groups: IntArray): List<String> {
        val ans: MutableList<String> = mutableListOf()
        val n = words.size
        for (i in 0 until n) {
            if (i == 0 || groups[i] != groups[i - 1]) {
                ans.add(words[i])
            }
        }
        return ans
    }
}