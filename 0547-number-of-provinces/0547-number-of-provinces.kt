class UnionFind(size: Int) {
    private val root = IntArray(size)

    init {
        for (i in 0 until size) {
            root[i] = i
        }
    }

    fun find(x: Int): Int {
        var x = x
        while (x != root[x]) {
            x = root[x]
        }
        return x
    }

    fun union(x: Int, y: Int) {
        val rootX = find(x)
        val rootY = find(y)
        if (rootX != rootY) {
            root[rootY] = rootX
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
                    dsu.union(i, j)
                }
            }
        }

        return numberOfComponents
    }
}
