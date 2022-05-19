class Solution {

    /**
     * @param Integer[] $nums1
     * @param Integer $m
     * @param Integer[] $nums2
     * @param Integer $n
     * @return NULL
     */
    function merge(&$nums1, $m, $nums2, $n) {
        $array = [];
        
        for($i=0; $i<$m; $i++){
            $array[] = $nums1[$i];
        }
        
        for($i=0; $i<$n; $i++){
            $array[] = $nums2[$i];
        }
        
        $nums1 = $array;
        
        sort($nums1);
    }
}