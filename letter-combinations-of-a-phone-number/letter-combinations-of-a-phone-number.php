class Solution {

    /**
     * @param String $digits
     * @return String[]
     */
    function letterCombinations($digits) {
        if($digits == ""){
            return [];
        }
        
        
        $phoneLetter = [
            2 => ['a','b','c'],
            3 => ['d','e','f'],
            4 => ['g','h','i'],
            5 => ['j','k','l'],
            6 => ['m','n','o'],
            7 => ['p','q','r','s'],
            8 => ['t','u','v'],
            9 => ['w','x','y','z']
        ];
        
        $digits = str_split($digits);
        $result = [];
        for($i=0; $i < count($digits); $i++){
            if(empty($result)){
                $result = $phoneLetter[$digits[$i]];
                continue;
            }
            $temp = null;
            foreach($result as $r){
                foreach($phoneLetter[$digits[$i]] as $l){
                    $temp[] = "{$r}{$l}";
                }
            }
            $result = $temp;
        }
        return $result;
    }
}