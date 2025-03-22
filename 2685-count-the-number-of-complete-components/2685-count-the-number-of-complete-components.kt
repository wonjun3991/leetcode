class Solution {
    fun countCompleteComponents(n: Int, edges: Array<IntArray>): Int {
        val adjencyList = Array<MutableList<Int>>(n) { mutableListOf() }
        edges.forEach {
            adjencyList[it[0]].add(it[1])
            adjencyList[it[1]].add(it[0])
        }


        var count = 0

        var visited = mutableSetOf<Int>()
        for (i in 0 until n) {
            if (visited.contains(i)) {
                continue
            }

            var tempVisited = mutableSetOf<Int>()
            if (isCycle(i, adjencyList, tempVisited, adjencyList[i].count())) {
                visited.addAll(tempVisited)
                if(tempVisited.count() - 1 == adjencyList[i].count()){
                    count++    
                }
                
            }
        }

        return count
    }

    fun isCycle(n: Int, adjencyList: Array<MutableList<Int>>, visited: MutableSet<Int>, count: Int): Boolean {
        visited.add(n)
        println(visited)

        if (adjencyList[n].size != count) {
            return false
        }

        val filtered = adjencyList[n]
            .filter { !visited.contains(it) }


        if (filtered.isEmpty()) {
            return true
        }

        return filtered
            .all { isCycle(it, adjencyList, visited, count) }
    }
}
