class Solution {

    /**
     * @param String $s
     * @return Integer
     */
    function romanToInt($s) {
        $romans = array(
            'M' => 1000,
            'CM' => 900,
            'D' => 500,
            'CD' => 400,
            'C' => 100,
            'XC' => 90,
            'L' => 50,
            'XL' => 40,
            'X' => 10,
            'IX' => 9,
            'V' => 5,
            'IV' => 4,
            'I' => 1,
        );

        
        $result = 0;

        foreach ($romans as $key => $value) {
            while (strpos($s, $key) === 0) {
                $result += $value;
                $s = substr($s, strlen($key));
            }
        }
        return $result;
    }
}