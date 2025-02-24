import java.util.*
import kotlin.math.max


class Solution {
    private lateinit var bobPath: MutableMap<Int, Int>
    private lateinit var visited: BooleanArray
    private lateinit var tree: MutableList<MutableList<Int>>

    fun mostProfitablePath(edges: Array<IntArray>, bob: Int, amount: IntArray): Int {
        val n = amount.size
        var maxIncome = Int.MIN_VALUE
        tree = ArrayList()
        bobPath = HashMap()
        visited = BooleanArray(n)
        val nodeQueue: Queue<IntArray> = LinkedList()
        nodeQueue.add(intArrayOf(0, 0, 0))
        for (i in 0 until n) {
            tree.add(ArrayList())
        }

        for (edge in edges) {
            tree.get(edge[0]).add(edge[1])
            tree.get(edge[1]).add(edge[0])
        }

        findBobPath(bob, 0)

        Arrays.fill(visited, false)
        while (!nodeQueue.isEmpty()) {
            val node = nodeQueue.poll()
            val sourceNode = node[0]
            val time = node[1]
            var income = node[2]

            if (!bobPath.containsKey(sourceNode) ||
                time < bobPath.get(sourceNode)!!
            ) {
                income += amount[sourceNode]
            } else if (time == bobPath.get(sourceNode)) {
                income += amount[sourceNode] / 2
            }

            if (tree.get(sourceNode).size == 1 && sourceNode != 0) {
                maxIncome = max(maxIncome.toDouble(), income.toDouble()).toInt()
            }
            for (adjacentNode in tree.get(sourceNode)) {
                if (!visited[adjacentNode]) {
                    nodeQueue.add(intArrayOf(adjacentNode, time + 1, income))
                }
            }

            visited[sourceNode] = true
        }
        return maxIncome
    }

    private fun findBobPath(sourceNode: Int, time: Int): Boolean {
        bobPath!![sourceNode] = time
        visited[sourceNode] = true

        if (sourceNode == 0) {
            return true
        }

        for (adjacentNode in tree!![sourceNode]) {
            if (!visited[adjacentNode]) {
                if (findBobPath(adjacentNode, time + 1)) {
                    return true
                }
            }
        }
        bobPath!!.remove(sourceNode)
        return false
    }
}

