class Solution {

    /**
     * @param Integer[] $height
     * @return Integer
     */
    function maxArea($height) {
        $left = 0;
        $right = count($height) -1;
        
        $maxArea = 0;
        
        while($right - $left > 0){
            $maxArea = max($maxArea, ($right - $left)*min($height[$left], $height[$right]));
            
            if($height[$left] >= $height[$right]){
                $right = $right - 1;
            } else{
                $left = $left + 1;
            }
        }
        return $maxArea;
    }
}