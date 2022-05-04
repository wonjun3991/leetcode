class Solution {

    /**
     * @param String $s
     * @return Integer
     */
    function lengthOfLastWord($s) {
        $array = explode(' ',trim($s));
        $count = count($array);
        return strlen($array[$count - 1]);
    }
}