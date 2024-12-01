class Solution {
    fun checkIfExist(arr: IntArray): Boolean {
        for ( i in 0 ..< arr.size) {
            for (j in 0 ..<arr.size) {
                if (i == j){
                    continue
                }
                if(arr[i] == 2 * arr[j]){
                    return true
                }
            }
        }
        return false
    }
}