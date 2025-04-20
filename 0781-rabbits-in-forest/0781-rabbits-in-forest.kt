class Solution {
    fun numRabbits(answers: IntArray): Int {
        val map = mutableMapOf<Int, Int>()

        answers.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }

        return map.keys.sumOf {
            if (it == 0) {
                return@sumOf map[it]!!
            }

            if(map[it]!! > it + 1){
                var count = map[it]!!
                var sum = it + 1
                while(count > it + 1){
                    sum += it + 1
                    count -= it + 1
                }
                return@sumOf sum
            }
            return@sumOf it + 1
        }
    }
}