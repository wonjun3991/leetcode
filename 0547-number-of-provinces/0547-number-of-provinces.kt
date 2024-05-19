class UnionFind(size: Int) {
    var parent: IntArray = IntArray(size)
    var rank: IntArray

    init {
        for (i in 0 until size) parent[i] = i
        rank = IntArray(size)
    }

    fun find(x: Int): Int {
        if (parent[x] != x) parent[x] = find(parent[x])
        return parent[x]
    }

    fun union_set(x: Int, y: Int) {
        val xset = find(x)
        val yset = find(y)
        if (xset == yset) {
            return
        } else if (rank[xset] < rank[yset]) {
            parent[xset] = yset
        } else if (rank[xset] > rank[yset]) {
            parent[yset] = xset
        } else {
            parent[yset] = xset
            rank[xset]++
        }
    }
}

class Solution {
    fun findCircleNum(isConnected: Array<IntArray>): Int {
        val n = isConnected.size
        val dsu = UnionFind(n)
        var numberOfComponents = n

        for (i in 0 until n) {
            for (j in i + 1 until n) {
                if (isConnected[i][j] == 1 && dsu.find(i) != dsu.find(j)) {
                    numberOfComponents--
                    dsu.union_set(i, j)
                }
            }
        }

        return numberOfComponents
    }
}