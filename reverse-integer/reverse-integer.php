class Solution {
    function reverse($x) {
        $result = (int)strrev(abs($x));
        if($result > 2 ** 31 - 1 || $result < -2 ** 31 ){
            return 0;
        }
        return $x < 0 ? "-{$result}" : $result;
    }
}