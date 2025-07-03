class Solution {
    fun kthCharacter(k: Int): Char {
        var s = listOf('a')
        while (s.lastIndex < k - 1) s += s.map { it + 1 }
        return s[k - 1]
    }
}
