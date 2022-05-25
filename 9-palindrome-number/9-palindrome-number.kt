class Solution {
    fun isPalindrome(x: Int): Boolean {
        val s = x.toString()
        var boolean = s == s.reversed()
        return boolean
    }
}