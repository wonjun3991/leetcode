class Solution {
    fun canConstruct(s: String, k: Int): Boolean {
        if(s.length == k) return true
        if(s.length < k) return false
        
        val charCountArray = toCharCountArray(s)
        var oddCount = 0

        for (i in charCountArray){
            if(i % 2 == 1) oddCount++
        }
        return oddCount <= k
    }

    fun toCharCountArray(s: String): IntArray {
        val array = IntArray(26) { 0 }
        for (i in s.toCharArray()) array[i.code - 'a'.code]++
        return array
    }
}