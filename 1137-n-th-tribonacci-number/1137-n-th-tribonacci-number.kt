class Solution {
    private val memoization = hashMapOf<Int, Int>()

    fun tribonacci(n: Int): Int {
        if(n == 0){
            return 0
        }
        
        if(n < 3){
            return 1
        }
        
        memoization[0] = 0
        memoization[1] = 1
        memoization[2] = 1

        for(v in 3..<n){
            memoization[v] = memoization[v-1]!! + memoization[v-2]!! + memoization[v-3]!!
        }

        return memoization[n-1]!! + memoization[n-2]!! + memoization[n-3]!!
    }
}
