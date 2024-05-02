import kotlin.math.abs
import kotlin.math.max

class Solution {
    fun findMaxK(nums: IntArray): Int {
        var max = -1

        for(i in 0 until nums.size - 1 ){
            for(l in i + 1 until nums.size){
                if(nums[l] == -nums[i]){
                    max = max(abs(nums[l]), max)
                }
            }
        }

        return max
    }
}
