internal class Solution {
    fun countOfSubstrings(word: String, k: Int): Long {
        var numValidSubstrings = 0L
        var start = 0
        var end = 0
        val vowelCount = HashMap<Char, Int>()
        var consonantCount = 0

        val nextConsonant = IntArray(word.length)
        var nextConsonantIndex = word.length
        for (i in word.length - 1 downTo 0) {
            nextConsonant[i] = nextConsonantIndex
            if (!isVowel(word[i])) {
                nextConsonantIndex = i
            }
        }
        
        while (end < word.length) {
            // insert new letter
            val newLetter = word[end]

            // update counts
            if (isVowel(newLetter)) {
                vowelCount[newLetter] = vowelCount.getOrDefault(newLetter, 0) + 1
            } else {
                consonantCount++
            }

            // shrink window if too many consonants in our window
            while (consonantCount > k) {
                val startLetter = word[start]
                if (isVowel(startLetter)) {
                    vowelCount[startLetter] = vowelCount[startLetter]!! - 1
                    if (vowelCount[startLetter] == 0) {
                        vowelCount.remove(startLetter)
                    }
                } else {
                    consonantCount--
                }
                start++
            }

            // while we have a valid window, try to shrink it
            while (start < word.length && vowelCount.keys.size == 5 && consonantCount == k
            ) {
                // count the current valid substring, as well as valid substrings produced by appending more vowels
                numValidSubstrings += (nextConsonant[end] - end).toLong()
                val startLetter = word[start]
                if (isVowel(startLetter)) {
                    vowelCount[startLetter] = vowelCount[startLetter]!! - 1
                    if (vowelCount[startLetter] == 0) {
                        vowelCount.remove(startLetter)
                    }
                } else {
                    consonantCount--
                }

                start++
            }
            end++
        }

        return numValidSubstrings
    }

    private fun isVowel(c: Char): Boolean {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
    }
}