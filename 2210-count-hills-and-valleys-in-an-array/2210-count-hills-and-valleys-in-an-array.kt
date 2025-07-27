class Solution {
    fun countHillValley(nums: IntArray): Int {
        var count = 0
        for(i in 1..<nums.lastIndex){
            val beforeNum = nums[i - 1]
            val currentNum = nums[i]
            
            if(beforeNum == nums[i]){
                continue
            }
            
            var nextNum: Int? = null
            for(j in i+1 until nums.size){
                if(currentNum != nums[j]){
                    nextNum = nums[j]
                    break
                }
            }
            if(nextNum == null){
                return count
            }
            
            if(beforeNum < currentNum && currentNum > nextNum){
                count++
            }
            
            if(beforeNum > currentNum && currentNum < nextNum){
                count++
            }
        }
        return count
    }
}
