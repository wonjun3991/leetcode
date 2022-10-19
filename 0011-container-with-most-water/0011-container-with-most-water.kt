import kotlin.math.*

class Solution {
    fun maxArea(height: IntArray): Int {
        var first = 0
        var last = height.size - 1
        var maxArea = 0
        
        while(first < last){
            val width = last - first
            maxArea = max(maxArea, min(height[first], height[last]) * width)
            if (height[first] <= height[last]){
                first++
            } else{
                last--
            }
            
        }
        return maxArea
    }
}