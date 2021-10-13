class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer
     */
    function threeSumClosest($nums, $target) {
        $nearestSum = $nums[0] + $nums[1] + $nums[2];
        $nearestValue = abs($target - $nearestSum);
        for($i = 0; $i < count($nums) - 2; $i++){
            for($j = $i + 1; $j< count($nums) - 1; $j++){
                for($k = $j + 1; $k < count($nums); $k++){
                    $sum = $nums[$i] + $nums[$j] + $nums[$k];
                    if($nearestValue > abs($target - $sum)){
                        $nearestValue = abs($target - $sum);
                        $nearestSum = $sum;
                    }
                }
            }
        }
        return $nearestSum;
    }
}