class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $k
     * @return Integer[]
     */
    function topKFrequent($nums, $k) {
        $numsArray = array_count_values($nums);
        arsort($numsArray);
        $numsArray = array_keys($numsArray);
    
        $array = [];
        for($i =0; $i<$k ; $i++){
            $array[] = $numsArray[$i];
        }
        return $array;
    }
}