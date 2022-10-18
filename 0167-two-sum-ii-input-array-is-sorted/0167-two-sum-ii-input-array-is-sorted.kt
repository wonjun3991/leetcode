class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var low = 0
        var high = numbers.size - 1
        while(low < high){
            var sum = numbers[low] + numbers[high]
            
            if(sum == target){
                return intArrayOf(low + 1, high + 1)
            } else if(sum < target){
                ++low
            } else{
                --high
            }
        }
        return intArrayOf(-1,-1)
    }
}