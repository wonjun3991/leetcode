class Solution {

    /**
     * @param Integer[] $nums
     * @return Integer
     */
    function maxSubArray($nums) {
  $dp = array();
        $length = count($nums);
        $result = PHP_INT_MIN;
        
        if(empty($nums))
            return 0;
        else if($length <= 2){
            return max($nums[0], $nums[1], ($nums[0] + $nums[1]));
        }
        
        $dp[0] = $nums[0];
        $result = max($dp[0], $result);
        
        for($i = 1; $i < $length; $i++){

            $dp[$i] = max($nums[$i] + $dp[$i-1], $nums[$i]);   
            $result = max($result,$dp[$i]);
            
        }
                 
        return $result;
    }
}