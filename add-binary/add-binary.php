class Solution {

    /**
     * @param String $a
     * @param String $b
     * @return String
     */
    function addBinary($a, $b) {
        $aLength = strlen($a);
        $bLength = strlen($b);
        $aRev = strrev($a);
        $bRev = strrev($b);
        $maxStrRev = '';
        $maxLength = 0;
        if($aLength >= $bLength){
            $minLength = $bLength;
            $maxLength = $aLength;
            $maxStrRev = $aRev;
        }else {
            $minLength = $aLength;
            $maxLength = $bLength;
            $maxStrRev = $bRev;
        }
        
        $i = 0;
        $beforeData = 0;
        
        $number = '';
        for(;$i< $minLength; $i++){
            $sum = (int)$aRev[$i] + (int)$bRev[$i] + $beforeData;
            $beforeData = 0;
            if( $sum >= 2 ){
                $beforeData = 1;
                $sum = $sum - 2;
            }
            $number = $number.$sum;
        }
        
        for(; $i< $maxLength; $i++){
            $sum = (int)$maxStrRev[$i] + $beforeData;
            $beforeData = 0;
            if($sum == 2){
                $beforeData = 1;
                $sum = 0;
            }
            $number = $number.$sum;
        }
        if($beforeData == 1){
            $number = $number.$beforeData;
        }
        return strrev($number);
    }
}