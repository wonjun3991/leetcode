/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    var sum = 0
    fun sumOfLeftLeaves(root: TreeNode?): Int {
        if (root == null || (root.left == null && root.right == null)) return sum
        dfs(root, false)
        return sum
    }
    
    private fun dfs(node: TreeNode, isLeft : Boolean) {
        if (isLeft && node.left == null && node.right == null) sum += node.`val`
        node.left?.let { dfs(it, true) }
        node.right?.let { dfs(it, false) }
    }
}