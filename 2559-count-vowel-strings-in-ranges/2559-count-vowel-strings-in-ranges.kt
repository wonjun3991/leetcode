class Solution {
    fun vowelStrings(words: Array<String>, queries: Array<IntArray>): IntArray {
        val vowels = hashSetOf('a', 'e', 'i', 'o', 'u')
        var count = 0
        val vowelsPrefixSum: IntArray = words.map { word ->
            if (vowels.contains(word.first()) && vowels.contains(word.last())){
                count++
            }
            return@map count
        }.toIntArray()
        
        println(vowelsPrefixSum.joinToString(","))

        return queries.map { query ->
            if (query[0] == 0){
                return@map vowelsPrefixSum[query[1]]
            }
            return@map vowelsPrefixSum[query[1]] - vowelsPrefixSum[query[0] - 1]
        }.toIntArray()
    }
}