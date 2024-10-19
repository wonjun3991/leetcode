class Solution {
    fun findKthBit(n: Int, k: Int): Char {
        if (n == 1) return '0'

        val len = 1 shl n

        if (k < len / 2) {
            return findKthBit(n - 1, k);
        }
        if (k == len / 2) {
            return '1';
        }
        
        val correspondingBit = findKthBit(n - 1, len - k);
        if (correspondingBit == '0'){
            return '1'
        }
        
        return '0'
    }
}