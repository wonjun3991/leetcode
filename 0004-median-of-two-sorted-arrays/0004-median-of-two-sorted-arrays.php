class Solution {
    function findMedianSortedArrays($firstNums, $secondNums) {
        $firstNumsLength = count($firstNums);
        $secondNumsLength = count($secondNums);
        $mergeNumsLength = $firstNumsLength + $secondNumsLength;
        
        $firstNumsIndex = 0;
        $secondNumsIndex = 0;
        $mergeNumsIndex = 0;
        
        $numsMerge = [];
            
        while($firstNumsIndex < $firstNumsLength && $secondNumsIndex < $secondNumsLength){
            if($firstNums[$firstNumsIndex] < $secondNums[$secondNumsIndex]){
                $numsMerge[$mergeNumsIndex] = $firstNums[$firstNumsIndex];
                $firstNumsIndex = $firstNumsIndex + 1;
            } else{
                $numsMerge[$mergeNumsIndex] = $secondNums[$secondNumsIndex];
                $secondNumsIndex = $secondNumsIndex + 1;
            } 
            $mergeNumsIndex = $mergeNumsIndex + 1;
        }
        
        if($firstNumsIndex == $firstNumsLength){
            for(;$mergeNumsIndex < $mergeNumsLength; $mergeNumsIndex = $mergeNumsIndex + 1){
                $numsMerge[$mergeNumsIndex] = $secondNums[$secondNumsIndex];
                $secondNumsIndex = $secondNumsIndex + 1;
            }
        } else{
            for(;$mergeNumsIndex < $mergeNumsLength; $mergeNumsIndex = $mergeNumsIndex + 1){
                $numsMerge[$mergeNumsIndex] = $firstNums[$firstNumsIndex];
                $firstNumsIndex = $firstNumsIndex + 1;
            }
        }
        
        if($mergeNumsLength % 2 == 0 ){
            return (float)($numsMerge[$mergeNumsLength / 2 - 1] + $numsMerge[$mergeNumsLength / 2]) / 2;
        } else{
            return $numsMerge[$mergeNumsLength /2];
        }
    }
}