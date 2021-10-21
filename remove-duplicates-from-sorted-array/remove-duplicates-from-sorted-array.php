class Solution {

    /**
     * @param Integer[] $nums
     * @return Integer
     */
    function removeDuplicates(&$nums) {
        $numsCount = count($nums);
        $nums = array_unique($nums);
        $numsUniqueCount = count($nums);
        for($i = $numsUniqueCount; $i< $numsCount; $i++){
            $nums[] = '_';
        }
        return $numsUniqueCount;
    }
}