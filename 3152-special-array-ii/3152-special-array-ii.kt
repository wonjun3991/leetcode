class Solution {
    fun isArraySpecial(nums: IntArray, queries: Array<IntArray>): BooleanArray {
        val prefix = IntArray(nums.size)
        prefix[0] = 0

        for (i in 1..<nums.size) {
            if (nums[i] % 2 == nums[i - 1] % 2) {
                prefix[i] = prefix[i - 1] + 1
            } else {
                prefix[i] = prefix[i - 1]
            }
        }

        return queries.map {
            prefix[it[1]] - prefix[it[0]] == 0
        }.toBooleanArray()
    }
}