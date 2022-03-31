class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $m
     * @return Integer
     */
    function splitArray($nums, $m) {
        $left = max($nums);
        $right = array_sum($nums);
        $mid = 0;
        while($left < $right){
            $mid = floor(($left + $right) / 2);
            
            if($this->canSplitNums($nums, $mid, $m)){
                $right = $mid;
            }else{
                $left = $mid + 1;
            }
        }
        
        return $left;
    }
    
    function canSplitNums($nums, $max, $m){
        $count = 1;
        $sum = 0;
        
        foreach($nums as $num){
            $sum += $num;
            if($sum > $max){
                $sum = $num;
                $count += 1;
            }
            
            if($count > $m){
                return false;
            }
        }
        
        return true;
    }
}