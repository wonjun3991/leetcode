class Solution {

    /**
     * @param Integer $n
     * @return Integer
     */
    function numTrees($n) {
        $c = 1;
        for($i=0; $i<$n; $i++){
            $c= $c*2*(2*$i+1) / ($i+2);
        }
        return floor($c);
    }
}