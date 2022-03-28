class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Boolean
     */
    function search($nums, $target) {
        return array_search($target,$nums) !== false ?true:false;
    }
}