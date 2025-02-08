class NumberContainers() {
    private val numbers: HashMap<Int, Int> = hashMapOf()
    private val numberSortedIndexMap: HashMap<Int, SortedSet<Int>> = hashMapOf()

    fun change(index: Int, number: Int) {
        if(numberSortedIndexMap.containsKey(numbers[index])){
            numberSortedIndexMap[numbers[index]]!!.remove(index)
        }
        numbers[index] = number
        numberSortedIndexMap.computeIfAbsent(number) { sortedSetOf() }.add(index)
    }

    fun find(number: Int): Int {
        if (numberSortedIndexMap.containsKey(number)) {
            val index = numberSortedIndexMap[number]!!.firstOrNull() ?: -1
            if (index == 0) {
                return -1
            }

            return index
        }
        return -1
    }
}