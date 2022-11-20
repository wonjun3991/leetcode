class Solution {
    fun findTheDifference(s: String, t: String): Char {
        val sc  = s.toCharArray().sorted()
        val st = t.toCharArray().sorted()

        for (i in 0 .. s.length-1) {
            if (sc[i] !== st[i]) {
                return st[i]
            }
        }
        return st[t.length - 1]
    }
}