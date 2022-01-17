class Solution {

    /**
     * @param String $pattern
     * @param String $s
     * @return Boolean
     */
    //
    function wordPattern($pattern, $s) {
        $words = explode(' ', $s);
        $patternMatching = [];
        if(strlen($pattern) > count($words)){
            return false;
        }
        
        for($i=0; $i<count($words); $i++){
            //기존 값이 존재할 경우 다르면 false
            //기존 값이 존재하지 않으면 해당 값을 넣어주기
            if(empty($patternMatching[$pattern[$i]])){
                if(in_array($words[$i],$patternMatching)){
                    return false;
                }
                $patternMatching[$pattern[$i]] = $words[$i];
            } else{
                if($patternMatching[$pattern[$i]] != $words[$i]){
                    return false;
                }
            }
        }
        return true;
    }
}