class Solution {
    /**
     * @param Integer $n
     * @return Integer
     */
    function reverseBits($n) {
        $strN = (string)$n;
        
        $strN = decbin($strN);
        
        $count = 32 - strlen($strN);
        for($i=0; $i < $count; $i++){
            $strN = "0{$strN}";
        }
        
        $strN = strrev($strN);
        
    
        $strN= bindec($strN);
        
        
        return $strN;
    }
}