class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer
     */
    function search($nums, $target) {
        if(in_array($target,$nums)){
            return array_search($target,$nums);
        } else{
            return -1;
        }
    }
}