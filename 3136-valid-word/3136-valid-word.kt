

class Solution {
    fun isValid(word: String): Boolean {
        // It contains a minimum of 3 characters.
        if (word.length < 3) {
            return false
        }

        val vowels = setOf('a', 'e', 'i', 'o', 'u')
        var vowelCount = 0
        var consonantCount = 0

        word.forEach {
            // It contains only digits (0-9), and English letters (uppercase and lowercase).
            if (it.isLetterOrDigit().not()) {
                return false
            }

            if (it.isLetter()) {
                // It includes at least one vowel.
                if (it.lowercaseChar() in vowels) {
                    vowelCount++
                } else {
                    // It includes at least one consonant.
                    consonantCount++
                }
            }
        }
        
        if(vowelCount > 0 && consonantCount > 0) {
            return true
        }
        
        return false
    }
}
