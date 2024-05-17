class Solution {
    fun removeLeafNodes(root: TreeNode?, target: Int): TreeNode? {

        val treeNode = TreeNode(-50)
        treeNode.right = root
        dfs(treeNode, target)
        return treeNode.right
    }

    fun dfs(before: TreeNode?, target: Int) {
        if (before!!.left != null) {
            dfs(before.left, target)
        }

        if (before!!.right != null) {
            dfs(before.right, target)
        }

        if (before!!.left != null
            && before!!.left!!.left == null
            && before!!.left!!.right == null
            && before!!.left!!.`val` == target
        ) {
            before.left = null
        }

        if (before!!.right != null
            && before!!.right!!.left == null
            && before!!.right!!.right == null
            && before!!.right!!.`val` == target
        ) {
            before.right = null
        }
    }
}