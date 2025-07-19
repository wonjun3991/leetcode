class Solution {
    fun removeSubfolders(folders: Array<String>): List<String> {
        val sortedFolders = folders.sorted().toMutableList()

        var i = 0
        var size = sortedFolders.size
        while (i < size) {
            val removeList = mutableListOf<String>()
            for (j in i + 1..<size) {
                if (sortedFolders[j].startsWith(sortedFolders[i] + "/")) {
                    removeList.add(sortedFolders[j])
                }
            }

            removeList.forEach {
                sortedFolders.remove(it)
            }

            i++
            size = sortedFolders.size
        }

        return sortedFolders
    }
}
