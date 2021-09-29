class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer[]
     */
    function twoSum($nums, $target) {
        for($first = 0 ; $first < count($nums); $first++){
            $findNum = $target -  $nums[$first];
            for($second = $first+1 ; $second< count($nums); $second++){
                if($nums[$second] == $findNum){
                    return [$first,$second];
                }
            }
        }
    }
}