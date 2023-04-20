class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val set = HashMap<Char, Int>()
        var left = 0
        var right = 0
        var result = 0

        while (left < s.length && right < s.length) {
            val element = s[right]
            if (set.contains(element)) left = kotlin.math.max(left, set[element]!!.plus(1))
            set[element] = right
            result = kotlin.math.max(result, right - left + 1)
            right += 1
        }

        return result
    }
}