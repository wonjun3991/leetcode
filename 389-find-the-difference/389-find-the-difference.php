class Solution {

    /**
     * @param String $s
     * @param String $t
     * @return String
     */
    function findTheDifference($s, $t) {
        $sArray = str_split($s);
        $tArray = str_split($t);
        sort($sArray);
        sort($tArray);
        
        for($i=0; $i< count($sArray); $i++){
            if($sArray[$i] != $tArray[$i]){
                return $tArray[$i];
            }
        }
        
        return $tArray[count($tArray) - 1];
    }
}