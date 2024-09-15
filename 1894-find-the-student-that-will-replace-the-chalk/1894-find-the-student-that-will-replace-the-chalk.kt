class Solution {
    fun chalkReplacer(chalk: IntArray, k: Int): Int {
        var idx = 0
        var pil = k
        while(pil >= 0){
            for(i in chalk.indices){
                idx = i
                pil -= chalk[i]
                if(pil < 0)
                    break
            }
        }

        return idx
    }
}