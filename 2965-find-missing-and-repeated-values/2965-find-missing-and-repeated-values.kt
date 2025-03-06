class Solution {
    fun findMissingAndRepeatedValues(grid: Array<IntArray>): IntArray {
        val number = grid.size * grid.size
        val array = BooleanArray(number + 1) { false }
        array[0] = true
        var missing = 0
        var duplicate = 0

        grid.forEach {
            it.forEach { i ->
                if (array[i] == true) {
                    duplicate = i
                }
                array[i] = true
            }
        }

        array.forEachIndexed { i, it ->
            if (it == false) {
                missing = i
                return@forEachIndexed
            }
        }

        return intArrayOf(duplicate, missing)
    }
}