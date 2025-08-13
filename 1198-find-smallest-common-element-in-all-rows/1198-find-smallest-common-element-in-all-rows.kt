class Solution {
    fun smallestCommonElement(mat: Array<IntArray>): Int {
        val commonElements = mat
            .fold(mat[0].toSet()) { acc, array -> acc.intersect(array.toSet()) }
        
        if (commonElements.isEmpty()) return -1
        return commonElements.min()
    }
}
