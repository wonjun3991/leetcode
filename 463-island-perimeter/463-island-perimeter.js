/**
 * @param {number[][]} grid
 * @return {number}
 */
var islandPerimeter = function(grid) {
    let result = 0;
    
    for(let rows = 0; rows < grid.length; rows++){
        for(let cols = 0; cols < grid[rows].length; cols++){
            if(grid[rows][cols] === 1){
                if(rows + 1 >= grid.length || grid[rows + 1][cols] !== 1){
                    result = result + 1;
                }
                
                if(rows - 1 < 0 || grid[rows - 1][cols] !== 1){
                    result = result + 1;
                }
                
                
                if(cols + 1 >= grid[rows].length || grid[rows][cols + 1] !== 1){
                    result = result + 1;
                }
                
                if(cols - 1 < 0 || grid[rows][cols - 1] !== 1){
                    result = result + 1;
                }
            }
        }
    }
    return result;
};