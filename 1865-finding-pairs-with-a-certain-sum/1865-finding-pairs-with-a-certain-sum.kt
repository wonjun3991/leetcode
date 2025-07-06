class FindSumPairs(
    private val nums1: IntArray,
    private val nums2: IntArray,
) {
    private val numToCount = mutableMapOf<Int, Int>()

    init {
        nums2.forEach {
            numToCount[it] = numToCount.getOrDefault(it, 0) + 1
        }
    }

    fun add(
        index: Int,
        `val`: Int,
    ) {
        numToCount[nums2[index]] = numToCount[nums2[index]]!! - 1
        nums2[index] += `val`
        numToCount[nums2[index]] = numToCount.getOrDefault(nums2[index], 0) + 1
    }

    fun count(tot: Int): Int = nums1.sumOf { numToCount.getOrDefault(tot - it, 0) }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * var obj = FindSumPairs(nums1, nums2)
 * obj.add(index,`val`)
 * var param_2 = obj.count(tot)
 */
