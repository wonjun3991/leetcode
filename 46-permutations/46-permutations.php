class Solution {
    private int $n = 0;
    private array $result = [];
    
    /**
     * @param Integer[] $nums
     * @return Integer[][]
     */
    function permute($nums) {
        $this->n = count($nums);
        $this->backtrack($nums);
        return $this->result;
    }
    
    function backtrack(&$nums,$first = 0){
        if($first === $this->n){
            $this->result[] = $nums;
        }
        for($i= $first; $i<$this->n;$i++){
            $this->swap($nums[$first],$nums[$i]);
            $this->backtrack($nums,$first+1);
            $this->swap($nums[$first],$nums[$i]);
        }
    }
    
    function swap(&$a, &$b)
    {
        list($a, $b) = [$b, $a];
    }
}