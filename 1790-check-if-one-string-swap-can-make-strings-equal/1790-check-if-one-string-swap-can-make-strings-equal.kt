class Solution {
    fun areAlmostEqual(s1: String, s2: String): Boolean {
        if (s1 == s2) {
            return true
        }
        val s1FrequencyMap = IntArray(26) { 0 }
        val s2FrequencyMap = IntArray(26) { 0 }
        var numDiffs = 0

        for (i in 0 until s1.length) {
            val s1Char = s1[i]
            val s2Char = s2[i]

            if (s1Char != s2Char) {
                numDiffs++
                if (numDiffs > 2) return false
            }

            s1FrequencyMap[s1Char.code - 'a'.code]++
            s2FrequencyMap[s2Char.code - 'a'.code]++
        }

        return s1FrequencyMap.contentEquals(s2FrequencyMap)
    }
}