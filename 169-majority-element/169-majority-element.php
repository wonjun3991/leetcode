class Solution {

    /**
     * @param Integer[] $nums
     * @return Integer
     */
    function majorityElement($nums) {
        $array = [];
        foreach($nums as $num){
            $array[$num] = $array[$num]? $array[$num] + 1 : 1;
        }
        $newArray = array_flip($array);
        return $newArray[max(array_keys($newArray))];
    }
}