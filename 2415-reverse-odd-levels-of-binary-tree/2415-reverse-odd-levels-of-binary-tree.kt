import java.util.*

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
    fun reverseOddLevels(root: TreeNode?): TreeNode? {
        val queue = LinkedList<TreeNode>()
        queue.offer(root)
        var count = 0


        while (queue.isNotEmpty()) {
            println(queue)
            val level = mutableListOf<TreeNode>()
            while (queue.isNotEmpty()) {
                level.add(queue.poll())
            }
            println(level)
            if (count % 2 == 1){
                val reverseVal = level.map { it.`val`}.reversed().toTypedArray()
                level.forEachIndexed { index, treeNode ->
                    if (count % 2 == 1) {
                        treeNode.`val` = reverseVal[index]
                    }
                    if(treeNode.left != null) {
                        queue.offer(treeNode.left)
                    }
                    if(treeNode.right != null) {
                        queue.offer(treeNode.right)
                    }

                }
                count++
                continue
            }

            level.forEach { treeNode ->
                if(treeNode.left != null) {
                    queue.offer(treeNode.left)
                }
                if(treeNode.right != null) {
                    queue.offer(treeNode.right)
                }
            }
            count++
        }

        return root
    }
}