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
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        inorder(root, result)
        return result
    }
    
    fun inorder(root: TreeNode?, result: MutableList<Int>){
        if(root != null){
            inorder(root.left, result)
            result.add(root.`val`)
            inorder(root.right, result)
        }
    }
}