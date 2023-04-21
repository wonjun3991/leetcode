class Solution {
    fun selfDividingNumbers(left: Int, right: Int): List<Int> {
        var list = mutableListOf<Int>()
        for (i in left..right) {
            var temp = i
            var addNum = true
            while (temp != 0 && addNum) {
               var d = temp % 10
               if (d == 0 || i % d != 0) {
                    addNum = false
               }
               temp = (temp / 10).toInt()
            }
            if (addNum) {
                list.add(i)
            }
       }
       return list 
    }
}