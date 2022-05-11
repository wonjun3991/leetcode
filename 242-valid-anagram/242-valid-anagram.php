class Solution {

    /**
     * @param String $s
     * @param String $t
     * @return Boolean
     */
    function isAnagram($s, $t) {
        $sArray = str_split($s);
        $tArray = str_split($t);
        sort($sArray);
        sort($tArray);
        return $sArray == $tArray;
    }
}