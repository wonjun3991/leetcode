class Solution {

    /**
     * @param String $s
     * @return Boolean
     */
    function isValid($s) {
        $sLength = strlen($s);
        $answerList = [
            '(' => ')',
            '[' => ']',
            '{' => '}',
        ];
        $stack = [];
        
        if($sLength % 2 != 0 ){
            return false;
        }
        for($i=0; $i < $sLength; $i++){
            if(array_key_exists($s[$i], $answerList)){
                array_push($stack, $s[$i]);
            }else{
                if($answerList[array_pop($stack)] != $s[$i]){
                    return false;
                }
            }
        }
        if(!empty($stack)){
            return false;
        }
        return true;
    }
}