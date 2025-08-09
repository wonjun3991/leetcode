class Solution {
    fun isPowerOfTwo(n: Int): Boolean = if(n <0) false else n.countOneBits() == 1
}
