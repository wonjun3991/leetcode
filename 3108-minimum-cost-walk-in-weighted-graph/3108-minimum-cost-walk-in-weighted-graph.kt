class Solution {
    lateinit var parent: IntArray
    lateinit var depth: IntArray

    fun minimumCost(n: Int, edges: Array<IntArray>, queries: Array<IntArray>): IntArray {
        // Initialize the parent array with -1 as initially each node belongs to its own component
        parent = IntArray(n)
        for (i in 0 until n) parent[i] = -1

        depth = IntArray(n)

        // All values are initially set to the number with only 1s in its binary representation
        val componentCost = IntArray(n)
        for (i in 0 until n) {
            componentCost[i] = Int.MAX_VALUE
        }

        // Construct the connected components of the graph
        for (edge in edges) {
            union(edge[0], edge[1])
        }

        // Calculate the cost of each component by performing bitwise AND of all edge weights in it
        for (edge in edges) {
            val root = find(edge[0])
            componentCost[root] = componentCost[root] and edge[2]
        }

        val answer = IntArray(queries.size)
        for (i in queries.indices) {
            val start = queries[i][0]
            val end = queries[i][1]

            // If the two nodes are in different connected components, return -1
            if (find(start) != find(end)) {
                answer[i] = -1
            } else {
                // Find the root of the edge's component
                val root = find(start)
                // Return the precomputed cost of the component
                answer[i] = componentCost[root]
            }
        }
        return answer
    }

    // Find function to return the root (representative) of a node's component
    private fun find(node: Int): Int {
        // If the node is its own parent, it is the root of the component
        if (parent[node] == -1) return node
        // Otherwise, recursively find the root and apply path compression
        return find(parent[node]).also { parent[node] = it }
    }

    // Union function to merge the components of two nodes
    private fun union(node1: Int, node2: Int) {
        var root1 = find(node1)
        var root2 = find(node2)

        // If the two nodes are already in the same component, do nothing
        if (root1 == root2) return

        // Union by depth: ensure the root of the deeper tree becomes the parent
        if (depth[root1] < depth[root2]) {
            val temp = root1
            root1 = root2
            root2 = temp
        }

        // Merge the two components by making root1 the parent of root2
        parent[root2] = root1

        // If both components had the same depth, increase the depth of the new root
        if (depth[root1] == depth[root2]) {
            depth[root1]++
        }
    }
}