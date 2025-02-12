import java.util.PriorityQueue
import kotlin.math.max

class Solution {
    fun maximumSum(nums: IntArray): Int {
        val digitMap = HashMap<Int, MutableList<Int>>()
        nums.forEach {
            digitMap.computeIfAbsent(digitSum(it)) { mutableListOf() }.add(it)
        }

        var maxSum = -1

        digitMap.keys.forEach {
            val numsByDigit = digitMap[it]!!
            if (numsByDigit.size < 2) {
                return@forEach
            }

            for (i in 0 until numsByDigit.size) {
                for (j in i + 1 until numsByDigit.size) {

                    val sum = numsByDigit[i] + numsByDigit[j]
                    if (digitSum(sum) == it) {
                        maxSum = max(maxSum, sum)
                    }
                }
            }
        }

        return maxSum
    }


    fun digitSum(num: Int): Int {
        var varnum = num
        var sum = 0

        while (varnum > 0) {
            sum += varnum % 10
            varnum /= 10
        }

        return sum
    }
}