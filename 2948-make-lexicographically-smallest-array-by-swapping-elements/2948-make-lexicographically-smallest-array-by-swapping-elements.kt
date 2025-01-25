import java.util.*
import kotlin.math.abs

class Solution {
    fun lexicographicallySmallestArray(nums: IntArray, limit: Int): IntArray {
        val numsSorted = IntArray(nums.size)
        for (i in nums.indices) numsSorted[i] = nums[i]
        Arrays.sort(numsSorted)

        var currGroup = 0
        val numToGroup = HashMap<Int, Int>()
        numToGroup[numsSorted[0]] = currGroup

        val groupToList = HashMap<Int, LinkedList<Int>>()
        groupToList[currGroup] = LinkedList(Arrays.asList(numsSorted[0]))

        for (i in 1 until nums.size) {
            if (abs((numsSorted[i] - numsSorted[i - 1]).toDouble()) > limit) {
                currGroup++
            }
            
            numToGroup[numsSorted[i]] = currGroup
            
            if (!groupToList.containsKey(currGroup)) {
                groupToList[currGroup] = LinkedList()
            }
            groupToList[currGroup]!!.add(numsSorted[i])
        }
        
        for (i in nums.indices) {
            val num = nums[i]
            val group = numToGroup[num]!!
            nums[i] = groupToList[group]!!.pop()
        }

        return nums
    }
}