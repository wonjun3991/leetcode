class Solution {

    /**
     * @param String $s
     * @return String[][]
     */
    function partition($s) {
        $result = [];
        $currentList = [];
        $this->dfs(0, $result, $currentList, $s);
        return $result;
    }
    
    function dfs($start, &$result, &$currentList, $s){
        if($start >= strlen($s)){
            $result[] = $currentList;
        }
        for($end = $start; $end < strlen($s); $end++){
            if($this->isPalindrome($s, $start, $end)){
                $currentList[] = substr($s, $start, $end - $start + 1);
                $this->dfs($end + 1, $result, $currentList, $s);
                array_pop($currentList);
            }
        }
    }
    
    function isPalindrome($s, $low, $high){
        while($low < $high){
            if($s[$low++] != $s[$high--]){
                return false;
            }
        }
        return true;
    }
}