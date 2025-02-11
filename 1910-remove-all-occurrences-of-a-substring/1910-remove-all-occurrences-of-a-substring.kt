class Solution {
    fun removeOccurrences(s: String, part: String): String {
        val str = StringBuilder()

        for (c in s.toCharArray()) {
            str.append(c)
            if (c == part.last() && str.length >= part.length) {
                var isOccurrence = true
                for (i in 0 until part.length) {
                    isOccurrence = isOccurrence.and(str[str.lastIndex - i] == part[part.lastIndex - i])
                }

                if (isOccurrence) {
                    str.delete(str.lastIndex - part.lastIndex, str.length)
                }
                println(str.toString())
            }
        }

        return str.toString()
    }
}