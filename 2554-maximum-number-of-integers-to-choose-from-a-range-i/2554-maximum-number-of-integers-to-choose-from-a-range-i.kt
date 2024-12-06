class Solution {
    fun maxCount(banned: IntArray, n: Int, maxSum: Int): Int {
        val sortedBanned = banned.toSortedSet().toList()
        var count = 0
        var bannedIndex = 0
        var sum = 0
        for(i in 1 .. n){
            if(bannedIndex < sortedBanned.size && i == sortedBanned[bannedIndex]){
                bannedIndex++
                continue
            }
            sum += i

            if( sum > maxSum){
                return count
            }

            count++
        }

        return count
    }
}