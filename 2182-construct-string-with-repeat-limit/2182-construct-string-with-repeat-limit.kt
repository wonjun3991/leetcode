
import java.util.*
import kotlin.math.min

class Solution {
    fun repeatLimitedString(s: String, repeatLimit: Int): String {
        val freq: MutableMap<Char, Int> = HashMap()
        for (ch in s.toCharArray()) {
            freq[ch] = freq.getOrDefault(ch, 0) + 1
        }

        val maxHeap = PriorityQueue { a: Char?, b: Char? ->
            Character.compare(
                b!!,
                a!!
            )
        }

        for (ch in freq.keys) {
            maxHeap.offer(ch)
        }

        val result = StringBuilder()

        while (!maxHeap.isEmpty()) {
            val ch = maxHeap.poll()
            val count = freq[ch]!!

            val use = min(count.toDouble(), repeatLimit.toDouble()).toInt()
            for (i in 0 until use) {
                result.append(ch)
            }

            freq[ch!!] = count - use

            if (freq[ch]!! > 0 && !maxHeap.isEmpty()) {
                val nextCh = maxHeap.poll()
                result.append(nextCh)
                freq[nextCh!!] = freq[nextCh]!! - 1
                if (freq[nextCh]!! > 0) {
                    maxHeap.offer(nextCh)
                }
                maxHeap.offer(ch)
            }
        }

        return result.toString()
    }
}