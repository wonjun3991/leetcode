class Solution {

    /**
     * @param Integer $n
     * @return Integer[][]
     */
    function generateMatrix($n) {
        $cnt = 1;
        $array = [];
        for ( $layer = 0; $layer < ($n+ 1) / 2; $layer++) {
            for ( $ptr = $layer; $ptr < $n- $layer; $ptr++) {
                $result[$layer][$ptr] = $cnt++;
            }
            for ( $ptr = $layer + 1; $ptr < $n- $layer; $ptr++) {
                $result[$ptr][$n- $layer - 1] = $cnt++;
            }

            for ( $ptr = $layer + 1; $ptr < $n- $layer; $ptr++) {
                $result[$n- $layer - 1][$n- $ptr - 1] = $cnt++;
            }
            
            for ( $ptr = $layer + 1; $ptr < $n- $layer - 1; $ptr++) {
                $result[$n- $ptr - 1][$layer] = $cnt++;
            }
        }
        foreach($result as &$row){
            ksort($row);
        }
        return $result;
    }
}