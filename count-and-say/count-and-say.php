class Solution {

    /**
     * @param Integer $n
     * @return String
     */
    function countAndSay($n) {
        if($n == 1){
            return "1";
        }
        $count = $this->countAndSay($n - 1);
        $resultArray = [];
        $result = "";
        
        for($i=0; $i<strlen($count);$i++){
           $k = 1;
            while($count[$i] == $count[$i+1]){
                $k++;
                $i++;
            }
            $result .= "{$k}{$count[$i]}";
        }
        
        return $result;
    }
}