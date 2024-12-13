class Solution {
    fun getKth(lo: Int, hi: Int, k: Int): Int {
        val powered: Array<Pair<Int, Int>> = IntRange(lo, hi).map {
            Pair(it, power(it))
        }.sortedBy { it.second }.toTypedArray()

        powered.forEach {
            println("${it.first} -> ${it.second}")
        }
        return powered[k - 1].first
    }

    fun power(i: Int): Int {
        var copyInt = i
        var count = 0
        while (copyInt != 1) {
            if (copyInt % 2 == 0) {
                copyInt /= 2
            } else {
                copyInt = copyInt * 3 + 1
            }
            count++
        }
        return count
    }
}