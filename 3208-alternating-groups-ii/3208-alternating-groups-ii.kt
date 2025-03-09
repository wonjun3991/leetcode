class Solution {
    fun numberOfAlternatingGroups(colors: IntArray, k: Int): Int {
        val newColors = colors.toMutableList()
        for (i in 0 until k - 1) {
            newColors.add(colors[i])
        }

        var count = 0
        var curr = 0

        while (curr < colors.size) {
            var continuousCount = 1
            var next = curr + 1
            while (newColors[curr].xor(newColors[next]) == 1) {
                continuousCount++
                curr = next
                next += 1

                if (next >= newColors.size) {
                    break
                }
            }
            if (continuousCount >= k) {
                count += continuousCount - k + 1
            }
            curr = next
        }

        return count
    }
}