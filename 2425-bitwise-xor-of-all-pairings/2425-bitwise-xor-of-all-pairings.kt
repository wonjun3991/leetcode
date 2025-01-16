class Solution {
    fun xorAllNums(nums1: IntArray, nums2: IntArray): Int {
        val nums2reduce = getXorCount(nums2.reduce { acc, i -> acc.xor(i) }, nums1.size)
        val nums1reduce = getXorCount(nums1.reduce { acc, i -> acc.xor(i) }, nums2.size)
        
        return nums1reduce.xor(nums2reduce)
    }

    fun getXorCount(num:Int, count:Int):Int{
        var result = num
        for (i in 1 until count){
            result = result.xor(num)
        }
        return result
    }
}