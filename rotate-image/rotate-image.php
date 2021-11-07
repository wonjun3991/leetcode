class Solution {

    /**
     * @param Integer[][] $matrix
     * @return NULL
     */
    function rotate(&$matrix) {
        $rotate = array_fill(0,count($matrix),array_fill(0,count($matrix[0]),0));
        $rowCount = count($matrix) - 1;
        foreach($matrix as $row){
            $columnCount = 0;
            foreach($row as $column){
                $rotate[$columnCount][$rowCount] = $column;
                $columnCount = $columnCount + 1;
            }
            $rowCount = $rowCount - 1;
        }
        $matrix = $rotate;
    }
}