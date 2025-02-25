import kotlin.math.pow

class Solution {
    fun numOfSubarrays(arr: IntArray): Int {
        val MOD = 10.0.pow(9).toInt() + 7
        val n = arr.size

        for (num in 0 until n) {
            arr[num] %= 2
        }

        val dpEven = IntArray(n)
        val dpOdd = IntArray(n)

        if (arr[n - 1] == 0) {
            dpEven[n - 1] = 1
        } else {
            dpOdd[n - 1] = 1
        }


        for (num in n - 2 downTo 0) {
            if (arr[num] == 1) {
                dpOdd[num] = (1 + dpEven[num + 1]) % MOD
                dpEven[num] = dpOdd[num + 1]
            } else {
                dpEven[num] = (1 + dpEven[num + 1]) % MOD
                dpOdd[num] = dpOdd[num + 1]
            }
        }

        var count = 0
        for (oddCount in dpOdd) {
            count += oddCount
            count %= MOD
        }
        return count
    }
}