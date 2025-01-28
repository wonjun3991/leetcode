import java.util.*

class Solution {
    fun checkIfPrerequisite(numCourses: Int, prerequisites: Array<IntArray>, queries: Array<IntArray>): List<Boolean> {
        val adjacencyList: Array<MutableList<Int>> = Array(numCourses) { mutableListOf() }
        val inDegreeCountList: Array<Int> = Array(numCourses) { 0 }

        prerequisites.forEach {
            adjacencyList[it[0]].add(it[1])
            inDegreeCountList[it[1]]++
        }

        val queue: Queue<Int> = LinkedList<Int>()

        for (i in inDegreeCountList.indices) {
            if (inDegreeCountList[i] == 0) {
                queue.add(i)
            }
        }

        val inDegreeConnectedList: Array<MutableSet<Int>> = Array(numCourses) { mutableSetOf() }

        while (queue.isNotEmpty()) {
            val cur = queue.remove()!!

            adjacencyList[cur].forEach { adjacency ->
                inDegreeConnectedList[adjacency].add(cur)
                inDegreeConnectedList[cur].forEach{
                    inDegreeConnectedList[adjacency].add(it)
                }
                inDegreeCountList[adjacency]--

                if(inDegreeCountList[adjacency] == 0) {
                    queue.add(adjacency)
                }
            }
        }

        return queries.map{ inDegreeConnectedList[it[1]].contains(it[0])}.toList()
    }
}