
import java.util.*
import kotlin.collections.ArrayDeque

internal class Solution {
    fun canBeValid(s: String, locked: String): Boolean {
        val length = s.length

        if (length % 2 == 1) {
            return false
        }

        val openBrackets = ArrayDeque<Int>()
        val unlocked = ArrayDeque<Int>()

        for (i in 0 until length) {
            if (locked[i] == '0') {
                unlocked.add(i)
            } else if (s[i] == '(') {
                openBrackets.add(i)
            } else if (s[i] == ')') {
                if (!openBrackets.isEmpty()) {
                    openBrackets.removeLast()
                } else if (!unlocked.isEmpty()) {
                    unlocked.removeLast()
                } else {
                    return false
                }
            }
        }
        
        while (!openBrackets.isEmpty() &&
            !unlocked.isEmpty() && openBrackets.last() < unlocked.last()
        ) {
            openBrackets.removeLast()
            unlocked.removeLast()
        }

        return openBrackets.isEmpty()
    }
}