class Solution {
    fun makeFancyString(s: String): String {
        if (s.length < 3) {
            return s
        }

        var first = 0
        var second = 1

        var str = mutableListOf(s[first], s[second])

        for (i in 2 until s.length) {
            if (s[first] != s[second] || s[second] != s[i]) {
                str.add(s[i])
            }

            first++
            second++
        }

        return str.joinToString("")
    }
}
