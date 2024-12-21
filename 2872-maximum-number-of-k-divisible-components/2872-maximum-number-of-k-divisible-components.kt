class Solution {
    fun maxKDivisibleComponents(
        n: Int,
        edges: Array<IntArray>,
        values: IntArray,
        k: Int
    ): Int {
        val adjList: Array<MutableList<Int>> = Array(n) { mutableListOf() }
        for (edge in edges) {
            val node1 = edge[0]
            val node2 = edge[1]
            adjList[node1].add(node2)
            adjList[node2].add(node1)
        }

        val componentCount = IntArray(1)

        dfs(0, -1, adjList, values, k, componentCount)

        return componentCount[0]
    }

    private fun dfs(
        currentNode: Int,
        parentNode: Int,
        adjList: Array<MutableList<Int>>,
        nodeValues: IntArray,
        k: Int,
        componentCount: IntArray
    ): Int {
        var sum = 0

        for (neighborNode in adjList[currentNode]) {
            if (neighborNode != parentNode) {
                sum += dfs(
                    neighborNode,
                    currentNode,
                    adjList,
                    nodeValues,
                    k,
                    componentCount
                )
                sum %= k
            }
        }

        sum += nodeValues[currentNode]
        sum %= k

        if (sum == 0) {
            componentCount[0]++
        }

        return sum
    }
}