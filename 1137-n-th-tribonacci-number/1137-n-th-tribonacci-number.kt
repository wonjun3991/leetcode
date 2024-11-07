class Solution {
    fun tribonacci(n: Int): Int {
        val fibonacci = mutableListOf<Int>()
        fibonacci.add(0)
        fibonacci.add(1)
        fibonacci.add(1)
        for (i in 3..n){
            fibonacci.add(fibonacci[i - 1] + fibonacci[i - 2] + fibonacci[i - 3])
        }

        return fibonacci[n]
    }
}