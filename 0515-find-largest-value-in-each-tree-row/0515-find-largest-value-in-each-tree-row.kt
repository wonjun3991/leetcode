import java.util.*
import kotlin.math.max


class Solution {
    fun largestValues(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()

        val queue = LinkedList<TreeNode>()
        val largestValues = ArrayList<Int>()
        queue.offer(root)

        while(queue.isNotEmpty()){
            val level = mutableListOf<TreeNode>()

            while(queue.isNotEmpty()){
                val node = queue.poll()
                level.add(node)
            }
            var max = level[0].`val`

            level.forEach {
                if(it.left != null){
                    queue.offer(it.left)
                }
                if(it.right != null){
                    queue.offer(it.right)
                }

                max = max(it.`val`, max)
            }

            largestValues.add(max)
        }

        return largestValues
    }
}