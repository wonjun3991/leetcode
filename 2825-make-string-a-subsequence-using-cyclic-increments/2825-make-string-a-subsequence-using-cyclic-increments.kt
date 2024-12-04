class Solution {
    fun canMakeSubsequence(str1: String, str2: String): Boolean {
        val str1Length = str1.length
        val str2Length = str2.length
        
        var str1Index = 0
        var str2Index = 0
        
        while (str1Index < str1Length && str2Index < str2Length) {
            if (str1[str1Index] == str2[str2Index] ||
                (str1[str1Index].code + 1 == str2[str2Index].code) ||
                (str1[str1Index].code - 25 == str2[str2Index].code)
            ) {
                str2Index++
            }
            str1Index++
        }

        return str2Index == str2Length
    }
}