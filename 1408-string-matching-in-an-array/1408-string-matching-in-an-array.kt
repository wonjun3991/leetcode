class Solution {
    fun stringMatching(words: Array<String>): List<String> {
        val sortedWords = words.sortedBy { it.length }.toTypedArray()
        val result = mutableListOf<String>()
        for (i in 0..<sortedWords.size) {
            for (j in i + 1..<sortedWords.size) {
                if(sortedWords[j].indexOf(sortedWords[i],0) != -1){
                    result.add(sortedWords[i])
                    break
                }
            }
        }

        return result.toList()
    }
}