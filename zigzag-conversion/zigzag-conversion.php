class Solution {
    function convert($s, $numRows) {
        if($numRows == 1){
            return $s;
        }
        
        $array = [];
        $n = strlen($s);
        $cycleLen = 2 * $numRows - 2;
        
        for($i = 0; $i < $numRows; $i++){
            for($j = 0; $j + $i < $n; $j = $j + $cycleLen){
                $array[] = $s[$j+$i];
                if($i !=0 && $i != $numRows -1 && $j + $cycleLen - $i < $n){
                    $array[] = $s[$j + $cycleLen - $i];
                }
                
            }
        }
        return implode($array);
    }
}