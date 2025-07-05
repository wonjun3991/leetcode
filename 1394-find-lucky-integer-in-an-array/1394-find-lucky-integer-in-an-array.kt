class Solution {
    fun findLucky(arr: IntArray): Int {
        val intToCount = sortedMapOf<Int, Int>()
        arr.forEach {
            intToCount[it] = intToCount.getOrDefault(it, 0) + 1
        }

        intToCount.keys.sortedDescending().forEach {
            if(intToCount.getOrDefault(it, 0) == it)
                return it
        }
        return -1
    }
}
