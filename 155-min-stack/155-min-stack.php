class MinStack {
    private array $array;
    
    function __construct() {
        $this->array = [];
    }
  
    /**
     * @param Integer $val
     * @return NULL
     */
    function push($val) {
        $this->array[] = $val;
        return null;
    }
  
    /**
     * @return NULL
     */
    function pop() {
        array_pop($this->array);
        return null;
    }
  
    /**
     * @return Integer
     */
    function top() {
        return end($this->array);
    }
  
    /**
     * @return Integer
     */
    function getMin() {
        return min($this->array);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * $obj = MinStack();
 * $obj->push($val);
 * $obj->pop();
 * $ret_3 = $obj->top();
 * $ret_4 = $obj->getMin();
 */