class Solution {
    fun canWinNim(n: Int): Boolean {
        if ( n - 3 < 0 || n % 4 != 0 ){
            return true;
        }
        return false;
    }
}