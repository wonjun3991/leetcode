import kotlin.math.max

// 짝수 + 짝수 % 2 = 0
// 짝수 + 홀수 % 2 = 1
// 홀수 + 짝수
// 홀수 + 홀수 % 2 = 0
// [1,2,1,1,2,1,2]
// [1,0,1,1,0,1,0]

class Solution {
    fun maximumLength(nums: IntArray): Int {
        val patterns = listOf(Pair(0, 0), Pair(0, 1), Pair(1, 0), Pair(1, 1))
        var count = 0
        patterns.forEach { pattern ->
            var temp = 0
            nums.forEach {
                if(it % 2 ==  if (temp % 2 == 0) pattern.first else pattern.second){
                    temp++
                }
            }

            count = max(count, temp)
        }
        
        return count
    }
}
