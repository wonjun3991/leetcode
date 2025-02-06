class Solution {
    fun tupleSameProduct(nums: IntArray): Int {
        val map = HashMap<Int, Int>()
        for (i in 0 until nums.size) {
            for (j in i + 1 until nums.size) {
                val key = nums[i] * nums[j]
                map[key] = map.getOrDefault(key, 0) + 1
            }
        }

        return map.keys
            .asSequence()
            .filter { map[it]!! >= 2 }
            .sumOf { 4 * map[it]!! * (map[it]!! - 1) }
    }
}
