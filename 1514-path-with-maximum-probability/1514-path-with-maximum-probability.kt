class Solution {
    fun maxProbability(n: Int, edges: Array<IntArray>, succProb: DoubleArray, start_node: Int, end_node: Int): Double {
        val graph = mutableMapOf<Int, MutableList<Pair<Int, Double>>>()
        for (i in edges.indices) {
            val (a, b) = edges[i]
            val prob = succProb[i]
            graph.computeIfAbsent(a) { mutableListOf() }.add(b to prob)
            graph.computeIfAbsent(b) { mutableListOf() }.add(a to prob)
        }
        val dist = DoubleArray(n) { 0.0 }
        dist[start_node] = 1.0
        val pq = PriorityQueue<Pair<Double, Int>>(compareBy { -it.first })
        pq.add(1.0 to start_node)
        while (pq.isNotEmpty()) {
            val (prob, node) = pq.poll()
            if (node == end_node) return prob
            for ((next, nextProb) in graph[node] ?: emptyList()) {
                val newProb = prob * nextProb
                if (newProb > dist[next]) {
                    dist[next] = newProb
                    pq.add(newProb to next)
                }
            }
        }
        return 0.0
    }
}