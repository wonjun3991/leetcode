class Solution {

    /**
     * @param Integer[] $height
     * @return Integer
     */
    function trap($height) {
       $res = 0;
    $size = count($height);
    $left[0] = $height[0];
    for ($i = 1; $i < $size; $i++) {
        $left[$i] = max($left[$i - 1], $height[$i]);
    }
    $right[$size - 1] = $height[$size - 1];
    for ($i = $size - 2; $i >= 0; $i--) {
        $right[$i] = max($right[$i + 1], $height[$i]);
    }

    for ($i = 1; $i < $size - 1; $i++) {
        $res += min($left[$i], $right[$i]) - $height[$i];
    }
    return $res;

    }
}