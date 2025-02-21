class FindElements(root: TreeNode?) {
    private val target: MutableSet<Int> = mutableSetOf(0)
    init {
        if (root != null) {
            var count = 0
            val queue = LinkedList<TreeNode?>()
            var hasNumber = true
            queue.add(root.left)
            queue.add(root.right)
            while(hasNumber){
                hasNumber = false
                for(i in 0 until queue.count()){
                    count++
                    val curr = queue.poll()
                    if(curr != null){
                        target.add(count)
                        queue.add(curr.left)
                        queue.add(curr.right)
                        hasNumber = true
                    } else{
                        queue.add(null)
                        queue.add(null)
                    }
                }
            }
        }
    }


    fun find(target: Int): Boolean {
        return this.target.contains(target)
    }

}