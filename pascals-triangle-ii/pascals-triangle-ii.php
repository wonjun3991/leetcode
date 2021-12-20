class Solution {

    /**
     * @param Integer $rowIndex
     * @return Integer[]
     */
    function getRow($rowIndex) {
        $result = [];
        for($i= 0; $i<= $rowIndex; $i++ ){
            $result[$i] = [];
            for($j = 0; $j <= $i; $j++){
                if($j == 0 || $j == $i){
                    $result[$i][] = 1; 
                } else{
                    $result[$i][] = $result[$i-1][$j -1] + $result[$i-1][$j];
                }
            }
        }
        return $result[$rowIndex];
    }
}