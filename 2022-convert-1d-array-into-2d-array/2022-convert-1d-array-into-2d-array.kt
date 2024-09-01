class Solution {
    fun construct2DArray(original: IntArray, m: Int, n: Int): Array<IntArray> {
        if (original.size != n * m) return arrayOf()
        val result = Array(m) { IntArray(n) }
        for (i in original.indices) {
            result[i / n][i % n] = original[i]
        }
        return result
    }
}