import kotlin.math.abs

class Solution {
    fun decrypt(code: IntArray, k: Int): IntArray {
        if (k == 0) {
            return code.map { 0 }.toIntArray()
        }

        val size = code.size
        val mutableArray = IntArray(size) { 0 }
        if (k > 0) {
            for (i in 0..<size) {
                for (j in 1..k) {
                    mutableArray[i] = mutableArray[i] + code.getOrElse((i + j) % size) { 0 }
                }
            }
            return mutableArray
        }

        for (i in 0..<size) {
            for (j in i - abs(k) ..< i) {
                mutableArray[i] = mutableArray[i] + code.getOrElse((size + j) % size) { 0 }
            }
        }
        return mutableArray
    }
}