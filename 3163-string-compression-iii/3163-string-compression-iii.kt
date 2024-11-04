class Solution {
    fun compressedString(word: String): String {
        val charList = mutableListOf<Char>()
        val countList = mutableListOf<Int>()

        word.forEach {
            if (charList.isEmpty()) {
                charList.add(it)
                countList.add(1)
            } else {
                if (countList.last() >= 9) {
                    charList.add(it)
                    countList.add(1)
                } else if (charList.last() == it) {
                    countList[charList.lastIndex]++
                } else {
                    charList.add(it)
                    countList.add(1)
                }
            }
        }

        return charList.zip(countList.toList()) { a, b ->
            b.toString() + a.toString()
        }.joinToString("")
    }
}