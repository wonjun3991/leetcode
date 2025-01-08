class Solution {
    fun countPrefixSuffixPairs(words: Array<String>): Int {
        var count = 0
        for (i in words.indices) {
            for (j in i + 1..<words.size ) {
                if(words[j].startsWith(words[i]) && words[j].endsWith(words[i])){
                    count++
                }
            }
        }

        return count
    }
}