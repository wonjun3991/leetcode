class Solution {

    /**
     * @param Integer $numRows
     * @return Integer[][]
     */
    function generate($numRows) {
        $numCount = count($numRows);
        $row = [];
        for($i=0; $i < $numRows; $i++){
            $column = [];
            for($j = 0; $j <= $i; $j++){
                if($j == 0 || $j == $i) {
                    $column[] = 1;
                } else{
                    $prev = $row[$i-1][$j-1];
                    $next = $row[$i-1][$j];
                    $column[] = $prev + $next;
                }
            }
            $row[] = $column;
        }
        return $row;
    }
}