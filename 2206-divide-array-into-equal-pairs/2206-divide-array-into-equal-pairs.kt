class Solution {
    fun divideArray(nums: IntArray): Boolean {
        val map = mutableMapOf<Int, Int>()

        nums.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }

        return map.all { it.value % 2 == 0 }
    }
}