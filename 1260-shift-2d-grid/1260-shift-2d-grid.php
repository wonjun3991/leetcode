class Solution {

    /**
     * @param Integer[][] $grid
     * @param Integer $k
     * @return Integer[][]
     */
    function shiftGrid($grid, $k) {
        $m = count($grid);
        $n = count($grid[0]);
        
        $array;
        
        if($k == 0){
            return $grid;
        }
        
        for($c = 0; $c<$k ; $c++){
            for($i=0;$i<$m;$i++){
                for($j=0;$j<$n;$j++){
                    if($i == $m-1 && $j == $n-1){
                        $array[0][0] = $grid[$i][$j];
                    } elseif($j === $n-1){
                        $array[$i+1][0] =  $grid[$i][$j];
                    } else{
                        $array[$i][$j+1] = $grid[$i][$j];
                    }
                }
                
            }   
            ksort($array[0]);
            ksort($array);
            $grid = $array;
        }
        
        return $array;
    }
}