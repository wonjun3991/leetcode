class Solution {

    /**
     * @param String $s
     * @return Integer
     */
    function lengthOfLongestSubstring($s) {
        $answer = 0;
        if(strlen($s) >= 1){
            $answer = 1;
        }
        for($firstIndex=0; $firstIndex<strlen($s); $firstIndex++){
            
            for($secondIndex = $answer; $secondIndex <=strlen($s) - $firstIndex; $secondIndex++){
                $subString = substr($s, $firstIndex, $secondIndex);
                if(!$this->isNotRepeatString($subString)){
                    break;   
                }
                if(strlen($subString) > $answer){
                    $answer = strlen($subString);
                }
            }
        }
        return $answer;
    }

    function isNotRepeatString($string){
        foreach(count_chars($string,1) as $char => $count){
            if($count > 1){
                return false;
            }
        }
        return true;
    }
}