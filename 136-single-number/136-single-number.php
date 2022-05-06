class Solution {

    /**
     * @param Integer[] $nums
     * @return Integer
     */
    function singleNumber($nums) {
        $numArray = [];
        foreach($nums as $num){
            $numArray[$num] = $numArray[$num]?$numArray[$num] + 1 : 1;
        }
        $number = 0;
        foreach($numArray as $key => $value){
            if($value === 1){
                $number = $key;
                break;
            }
        }
        return $number;
    }
}