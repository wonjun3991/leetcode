class Solution {
    fun maximumWealth(accounts: Array<IntArray>): Int {
        var maxWealth = 0
    
        for (account in accounts) {
            var wealth = account.sum()
            if (maxWealth < wealth){
                maxWealth = wealth
            }
        }
        return maxWealth
    }
}