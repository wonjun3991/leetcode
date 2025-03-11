class Solution {
    fun numberOfSubstrings(s: String): Int {
        val freq = IntArray(3)
        var start = 0
        var end = 0
        var count = 0

        while(end < s.length) {
            freq[s[end].code -  'a'.code]++

            while (haveAllCharacters(freq)) {
                count += s.length - end
                
                val leftChar = s[start]
                freq[leftChar.code - 'a'.code]--
                start++
            }

            end++
        }
        
        return count
    }

    fun haveAllCharacters(freq: IntArray): Boolean {
        return freq.all { it > 0 }
    }
}