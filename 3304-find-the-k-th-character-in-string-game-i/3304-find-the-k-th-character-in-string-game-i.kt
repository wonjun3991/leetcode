class Solution {
    fun kthCharacter(k: Int): Char {
        var s = listOf('a')
        while (s.lastIndex < k - 1) s += s.map { it + 1 }
        println(s)
        return s[k - 1]
    }
}
