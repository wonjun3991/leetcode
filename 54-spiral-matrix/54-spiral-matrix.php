class Solution {

    /**
     * @param Integer[][] $matrix
     * @return Integer[]
     */
    function spiralOrder($matrix) {
        $result = [];
        $rows = count($matrix);
        $columns = count($matrix[0]);
                    
        $up = 0;
        $left = 0;
        $right = $columns - 1;
        $down = $rows - 1;
        
        while (count($result) < $rows * $columns){
            for($col = $left; $col <= $right; $col++){
                $result[] = $matrix[$up][$col];
            }
            
            for($row = $up + 1; $row <= $down; $row++){
                $result[] = $matrix[$row][$right];
            }
            
            if($up != $down){
                for($col = $right -1; $col >= $left; $col--){
                    $result[] = $matrix[$down][$col];
                }
            }
            
            if($left != $right){
                for($row = $down - 1; $row > $up; $row--){
                    $result[] = $matrix[$row][$left];
                }
            }
            $left++;
            $right--;
            $up++;
            $down--;
        }
        return $result;
    }
}