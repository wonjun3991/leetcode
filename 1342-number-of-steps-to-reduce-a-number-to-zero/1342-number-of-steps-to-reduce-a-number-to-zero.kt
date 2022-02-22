class Solution {
    fun numberOfSteps(num: Int): Int {
        var number = num
        var count = 0
        while(number != 0){
            count++
            if(number % 2 == 0){
                number = number / 2
            } else{
                number = number - 1
            }
        }
        return count
    }
}