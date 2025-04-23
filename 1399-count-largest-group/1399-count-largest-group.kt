class Solution {
    fun countLargestGroup(n: Int): Int {
        val hashMap = HashMap<Int, MutableList<Int>>()
        for(i in 1 .. n){
            val number =i.toString().chars().map { it - '0'.code }.sum()
            hashMap.computeIfAbsent(number) { mutableListOf() }.add(i)
        }
        
        println(hashMap)

        return hashMap.values.count { it.size == hashMap.values.maxOf { it.size } }
    }
}