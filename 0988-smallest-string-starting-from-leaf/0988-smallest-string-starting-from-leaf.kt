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
    var smallestString = ""

    fun smallestFromLeaf(root: TreeNode?): String {
        dfs(root, "")
        return smallestString
    }

    fun dfs(treeNode: TreeNode?, currentString: String) {
        if (treeNode == null) {
            return
        }
        val concatString = (treeNode.`val` + 'a'.code).toChar() + currentString

        if (treeNode.left == null && treeNode.right == null){
            if(smallestString.isEmpty() || smallestString.compareTo(concatString) > 0){
                smallestString = concatString
            }
        }
        
        dfs(treeNode.left, concatString)
        dfs(treeNode.right, concatString)
    }
}