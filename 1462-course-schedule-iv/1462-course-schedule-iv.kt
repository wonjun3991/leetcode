import java.util.*
import kotlin.collections.HashSet

class Solution {
    fun checkIfPrerequisite(numCourses: Int, prerequisites: Array<IntArray>, queries: Array<IntArray>): List<Boolean> {
        val adjList = Array(numCourses) { mutableListOf<Int>() }
        val indegreeCount = Array(numCourses) { 0 }

        prerequisites.forEach {
            adjList[it[0]].add(it[1])
            indegreeCount[it[1]]++
        }

        val queue = LinkedList<Int>()
        for (i in 0 until numCourses) {
            if (indegreeCount[i] == 0) {
                queue.add(i)
            }
        }

        val connectedListMap = hashMapOf<Int, MutableSet<Int>>()

        while (queue.isNotEmpty()) {
            // 진입차수 0 인 Node
            val current = queue.removeFirst()

            // 0인 Node와 연결된 Node 목록
            adjList[current].forEach { adjacency ->
                // 연결된 Node에 current와 연결되었음을 명시
                connectedListMap.computeIfAbsent(adjacency) { HashSet() }.add(current)

                // current에 진입하는 Node들에도 해당 Node 들과 연결되었음을 명시
                connectedListMap.getOrDefault(current, HashSet()).forEach{
                    connectedListMap.get(adjacency)!!.add(it)
                }

                // 진입차수 차감
                indegreeCount[adjacency]--

                if(indegreeCount[adjacency] == 0){
                    queue.add(adjacency)
                }
            }
        }

        return queries.map {
            connectedListMap.getOrDefault(it[1], HashSet()).contains(it[0])
        }.toList()
    }
}