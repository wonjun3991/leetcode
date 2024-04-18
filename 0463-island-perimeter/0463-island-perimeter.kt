class Solution {
    fun islandPerimeter(grid: Array<IntArray>): Int {
        val directions = listOf(0 to -1, -1 to 0)
        var perimeter = 0

        for(h in grid.indices){
            for(w in grid[h].indices){
                if(grid[h][w] == 1){
                    perimeter += 4

                    directions.forEach{
                        val directionHeight = h + it.first
                        val directionWeight = w + it.second
                        if(directionHeight >= grid.size || directionHeight < 0){
                            return@forEach
                        }
                        if(directionWeight >= grid[h].size || directionWeight < 0){
                            return@forEach
                        }
                        if (grid[directionHeight][directionWeight] == 1 ){
                            perimeter -= 2
                        }
                    }
                }
            }
        }
        return perimeter
    }
}