class Solution {

    /**
     * @param Integer[] $stones
     * @return Integer
     */
    function lastStoneWeight($stones) {
        while(count($stones) != 1){
            rsort($stones);
            $max = array_splice($stones,0,1)[0];
            $next = array_splice($stones,0,1)[0];
                $stones[] = $max - $next;
        }            
        return $stones[0];
    }
}