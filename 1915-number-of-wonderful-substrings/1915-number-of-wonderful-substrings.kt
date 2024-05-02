class Solution {
    fun wonderfulSubstrings(word: String): Long {
        val map: MutableMap<Int, Int> = mutableMapOf()

        map[0] = 1

        var mask = 0
        var response = 0L

        for(i in word.indices){
            val bit = word[i] - 'a'
            mask = mask.xor(1.shl(bit))

            response += map.getOrDefault(mask, 0)

            map[mask] = map.getOrDefault(mask, 0) + 1

            for(odd in 0 until 10){
                response += map.getOrDefault(mask.xor(1.shl(odd)), 0)
            }
        }
        
        return response
    }
}
