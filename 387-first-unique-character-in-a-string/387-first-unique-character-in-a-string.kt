class Solution {
    fun firstUniqChar(s: String): Int {

    val hashTable = HashMap<Char, Int>()

     for (char: Char in s) {

        if (hashTable.containsKey(char)) {
            hashTable[char] = hashTable[char]!! + 1
        } else {
            hashTable[char] = 1
        }
     }


     s.forEachIndexed { index, char ->
        if (hashTable[char] == 1) {
            return index
        }
    }

    return -1
    }
}