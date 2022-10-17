class Solution {
    fun rotate(nums: IntArray, k: Int): Unit {
                val a: IntArray = IntArray(nums.size)
        for((index, value) in nums.withIndex()){
            a[(index + k) % nums.size] = nums[index]
        }
        for(i in 0 .. nums.size - 1){
            nums[i] = a[i]
        }
        
    }
}