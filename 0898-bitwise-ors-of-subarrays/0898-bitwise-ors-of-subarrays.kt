class Solution {
    fun subarrayBitwiseORs(arr: IntArray): Int {
        val uniqueNumbers = mutableSetOf<Int>()
        val curr = mutableSetOf(arr[0])
        arr.forEach { x ->
            val curr2 = mutableSetOf<Int>()
            curr.forEach {
                curr2.add(it or x)
            }
            curr2.add(x)
            curr.clear()
            curr.addAll(curr2)
            uniqueNumbers.addAll(curr)
        }
        
        return uniqueNumbers.size
    }
}
