import kotlin.math.min

class Solution {
    fun minimumRecolors(blocks: String, k: Int): Int {
        var min = Integer.MAX_VALUE
        for (i in 0 until blocks.length - k) {
            var count = 0

            for (j in i until i + k) {
                if(blocks[j] == 'W'){
                    count++
                }
            }
            
            min = min(count, min)
        }
        
        return min
    }
}