class Solution {
    fun findThePrefixCommonArray(a: IntArray, b: IntArray): IntArray {
        val hashmap = HashMap<Int, Int>()
        val result = IntArray(a.size)
        for(i in a.indices){
            hashmap[a[i]] = hashmap.getOrDefault(a[i], 0) + 1
            hashmap[b[i]] = hashmap.getOrDefault(b[i], 0) + 1
            result[i] = hashmap.filterValues { it == 2 }.count()
        }
        
        return result
    }
}