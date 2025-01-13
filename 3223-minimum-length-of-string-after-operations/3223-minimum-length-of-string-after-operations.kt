class Solution {
    fun minimumLength(s: String): Int {
        val hashMap = mutableMapOf<Char, Int>()
        s.toCharArray().forEach {
            hashMap[it] = hashMap.getOrDefault(it, 0) + 1
        }

        return hashMap.asSequence()
            .map {
                if (it.value == 0){
                    return@map 0
                }
                if (it.value % 2 == 1){
                    return@map 1
                }
                return@map 2
            }
            .sum()
    }
}

