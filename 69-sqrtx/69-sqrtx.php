class Solution {

    /**
     * @param Integer $x
     * @return Integer
     */
    function mySqrt($x) {
        $last = 1;
        for($i=0 ; $i<= $x ; $i++){
            $double = $i * $i;
            if($double == $x){
                return $i;
            }
            if($double < $x){
                $last = $i;
            }
            if($double > $x){
                return $last;
            }
        }
    }
}