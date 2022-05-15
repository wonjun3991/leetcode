class Solution {

    /**
     * @param Integer[] $nums
     * @return NULL
     */
    function moveZeroes(&$nums) {
        $zeroArray =[];
        $numArray = [];
        
        foreach($nums as $num){
            if($num == 0){
                $zeroArray[] = 0;
            } else{
                $numArray[] = $num;
            }
        }
        $nums = array_merge($numArray, $zeroArray);
    }
}