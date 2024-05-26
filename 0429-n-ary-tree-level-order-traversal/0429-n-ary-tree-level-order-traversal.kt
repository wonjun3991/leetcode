class Solution {
    val result: MutableList<List<Int>> = mutableListOf()

    fun levelOrder(root: Node?): List<List<Int>> {
        if(root != null){
            val element = mutableListOf(root)
            result.add(listOf(root.`val`))
            bfs(element)
        }


        return result
    }

    fun bfs(nodes: MutableList<Node>){
        val nextNodes = nodes.flatMap { it.children }.filterNotNull().toMutableList()
        if(nextNodes.isNotEmpty()) {
            result.add(nextNodes.map{ it.`val`})
            bfs(nextNodes)
        }
    }
}