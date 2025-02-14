class ProductOfNumbers() {
    private val products : MutableList<Int> = mutableListOf()
    fun add(num: Int) {
        products.add(num)
    }

    fun getProduct(k: Int): Int {
        var result = products.last()
        if(result == 0){
            return 0
        }

        for(i in 1 until  k){
            result = result * products[products.size - i - 1]
        }

        return result
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * var obj = ProductOfNumbers()
 * obj.add(num)
 * var param_2 = obj.getProduct(k)
 */