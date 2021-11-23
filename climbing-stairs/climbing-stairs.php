class Solution {

    /**
     * @param Integer $n
     * @return Integer
     */
    function climbStairs($n) {
        if($n == 1 || $n == 2){
            return $n;
        }
        
        $memo = [];
        $memo[1] = 1;
        $memo[2] = 2;
        
        return $this->doClimbStairs($n,$memo);
    }
    
    function doClimbStairs($n,&$memo){
        if($memo[$n]>0){
            return $memo[$n];
        }
        $memo[$n] = $this->doClimbStairs($n - 2, $memo) + $this->doClimbStairs($n - 1, $memo);
        
        return $memo[$n];
    }
}