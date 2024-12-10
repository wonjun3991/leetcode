class Solution {
    fun maximumLength(s: String): Int {
        val stringCount: MutableMap<String, Int> = HashMap()

        for (i in 0..<s.length) {
            val string = StringBuilder()

            for (j in i..<s.length) {
                if (string.length  == 0 || string.last() == s[j]) {
                    string.append(s[j])
                    stringCount[string.toString()] = stringCount.getOrDefault(string.toString(), 0) + 1
                } else{
                    break
                }
            }
        }

        var ans = 0
        for (str in stringCount.keys) {
            if (stringCount[str]!! >= 3 && str.length > ans) ans = str.length
        }

        if (ans == 0) return -1
        return ans
    }
}