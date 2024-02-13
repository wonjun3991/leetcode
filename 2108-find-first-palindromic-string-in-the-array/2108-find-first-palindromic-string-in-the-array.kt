class Solution {
    fun firstPalindrome(words: Array<String>): String {
        words.forEach { 
            if(it == it.reversed()){
                return it
            }
        }
        return ""
    }
}