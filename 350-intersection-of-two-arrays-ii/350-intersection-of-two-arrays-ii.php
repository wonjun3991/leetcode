class Solution {

    /**
     * @param Integer[] $nums1
     * @param Integer[] $nums2
     * @return Integer[]
     */
    function intersect($nums1, $nums2) {
        $result = [];
        
        foreach($nums1 as $num){
            if(in_array($num, $nums2)){
                $result[] = $num;
                unset($nums2[array_search($num, $nums2)]);
            }
        }
        sort($result);
        return $result;
    }
}