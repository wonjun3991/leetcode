class Solution {
    var moves = 0
    fun distributeCoins(root: TreeNode?): Int {
        moves = 0
        dfs(root)
        return moves
    }

    fun dfs(root: TreeNode?): Int{
        if(root == null){
            return 0
        }

        val leftCoins = dfs(root.left)
        val rightCoins = dfs(root.right)

        moves = moves + abs(leftCoins)  + abs(rightCoins) 

        return root.`val` - 1 + leftCoins + rightCoins
    }
}