class Solution {
    fun addDigits(num: Int): Int {
        val list: MutableList<Int> = emptyList<Int>().toMutableList()
        var number = num

        while(number >= 10){
            while(number >= 10){
                list.add(number / 10)
                number %= 10
            }
            list.add(number)
            number = list.sum()
            list.clear()
        }

        return number
    }
}