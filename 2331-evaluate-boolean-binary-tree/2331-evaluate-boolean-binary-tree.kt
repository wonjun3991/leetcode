class Solution {
    val logicalOperator = intArrayOf(2, 3)

    fun evaluateTree(root: TreeNode?): Boolean {
        val result = dfs(root!!)
        return result != 0
    }

    fun dfs(node: TreeNode): Int {
        if (node.left != null && node.left!!.`val` in logicalOperator){
            node.left!!.`val` = dfs(node.left!!)
        }

        if (node.right!= null && node.right!!.`val` in logicalOperator){
            node.right!!.`val` = dfs(node.right!!)
        }

        if(node.`val`  == 2){
            node.`val` = if((node.left!!.`val` == 1) || (node.right!!.`val` == 1)) 1 else 0
        }
        
        if(node.`val` == 3){
            node.`val` = if(node.left!!.`val` == 1 && node.right!!.`val` == 1) 1 else 0
        }


        return node.`val`
    }
}