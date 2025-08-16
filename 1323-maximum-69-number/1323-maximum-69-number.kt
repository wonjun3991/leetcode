class Solution {
    fun maximum69Number(num: Int): Int {
        val chars = num.toString().toCharArray()
        val indexOfFirst = chars.indexOfFirst { it == '6' }
        if (indexOfFirst != -1) {
            chars[indexOfFirst] = '9'
        }

        println(chars.joinToString(""))
        return chars.joinToString("").toInt()
    }
}
