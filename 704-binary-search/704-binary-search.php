class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer
     */
    function search ( $nums , $target ) {
         $start = 0 ;
         $end = count ( $nums );
         do {
             $mid = floor (( $end + $start )/ 2 );
             if ( $nums [ $mid ] ==$target ){
                 return $mid;
            }
            if ( $nums [ $mid ]< $target ){
                 $start = $mid + 1 ;
            }
            else {
                 $end = $mid - 1 ;
            }
        } while ( $end >= $start );
         return - 1 ;
    }
}