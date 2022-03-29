class Solution {

    /**
     * @param Integer[] $nums
     * @return Integer
     */
    function findDuplicate($nums) {
        $array = array_count_values($nums);
        foreach($array as $key => $value){
            if($value >= 2){
                return $key;
            }
        }
        return -1;
    }
}