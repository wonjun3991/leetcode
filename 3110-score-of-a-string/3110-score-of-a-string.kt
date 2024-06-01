import kotlin.math.abs

class Solution {
    fun scoreOfString(s: String): Int {
        var score = 0
        
        for( i in 0 until  s.length - 1){
            score += abs(s[i].code - s[i + 1].code) 
        }
        
        return score
    }
}
