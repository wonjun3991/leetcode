import java.util.*
import kotlin.collections.HashMap


class Solution {
    fun minimumOperations(root: TreeNode): Int {
        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)
        var totalSwaps = 0

        while (!queue.isEmpty()) {
            val levelSize = queue.size
            val levelValues = IntArray(levelSize)

            for (i in 0 until levelSize) {
                val node = queue.poll()
                levelValues[i] = node.`val`

                if (node.left != null) queue.add(node.left)
                if (node.right != null) queue.add(node.right)
            }

            totalSwaps += getMinSwaps(levelValues)
        }
        return totalSwaps
    }

    private fun getMinSwaps(original: IntArray): Int {
        var swaps = 0
        val target = original.clone().sorted()

        val pos: MutableMap<Int, Int> = HashMap()
        for (i in original.indices) {
            pos[original[i]] = i
        }

        for (i in original.indices) {
            if (original[i] != target[i]) {
                swaps++

                val curPos = pos[target[i]]!!
                pos[original[i]] = curPos
                original[curPos] = original[i]
            }
        }
        return swaps
    }
}