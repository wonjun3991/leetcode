class Solution {

    /**
     * @param String $s
     * @return String
     */
    function longestPalindrome($string) {
        $stringLength = strlen($string);
        $longestPalindromic = '';
        for($i= 0 ; $i< $stringLength; $i++){
            for($j= strlen($longestPalindromic); $j <= $stringLength - $i; $j++){
                $subString = substr($string, $i, $j);
                
                if($subString == strrev($subString)){
                    $longestPalindromic = $subString;
                }
            }
        }
        return $longestPalindromic;
    }
}