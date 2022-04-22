class MyHashMap {
    private array $array = [];
    /**
     */
    function __construct() {
        
    }
  
    /**
     * @param Integer $key
     * @param Integer $value
     * @return NULL
     */
    function put($key, $value) {
        $this->array[$key] = $value;
    }
  
    /**
     * @param Integer $key
     * @return Integer
     */
    function get($key) {
        return $this->array[$key]??-1;
    }
  
    /**
     * @param Integer $key
     * @return NULL
     */
    function remove($key) {
        unset($this->array[$key]);   
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * $obj = MyHashMap();
 * $obj->put($key, $value);
 * $ret_2 = $obj->get($key);
 * $obj->remove($key);
 */