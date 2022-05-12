class Solution {
    /**
     * @param Integer $n
     * @return Integer[]
     */
    function grayCode($n) {
        $result = [];
        $this->grayCodeSequence($result,$n);
        return $result;
    }
    
    function grayCodeSequence(&$result, $n){
        if($n ==0){
            $result = [0];
            return ;
        }
        
        $this->grayCodeSequence($result, $n-1);
        $currentLength = count($result);
        $mask = 1 << ($n - 1);
        for($i = $currentLength - 1 ; $i>=0 ; $i--){
            $result[] = $result[$i] | $mask;
        }
    }
}