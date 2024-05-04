import kotlin.math.max

class Solution {
    fun compareVersion(version1: String, version2: String): Int {
        val nums1 = version1.split(".")
        val nums2 = version2.split(".")

        val n1 = nums1.size
        val n2 = nums2.size

        for(i in 0 until max(n1, n2)){
            val i1 = if(i < n1) nums1[i].toInt() else 0 
            val i2 = if(i < n2) nums2[i].toInt() else 0
            
            if(i1 != i2){
                return if(i1 > i2) 1 else -1
            }
        }

        return 0
    }
}
