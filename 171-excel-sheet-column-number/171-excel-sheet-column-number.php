class Solution {

    /**
     * @param String $columnTitle
     * @return Integer
     */
    function titleToNumber($columnTitle) {
        $defaultNumber = 64;
        $multiple = 26;
        $sum = 0;
        for($i=0; $i<strlen($columnTitle); $i++){
            $index = strlen($columnTitle) - $i - 1;
            $value = (ord($columnTitle[$index]) - 64) * pow(26,$i);
            $sum = $sum + $value;
        }
        return $sum;
    }
}