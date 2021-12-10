class Solution {

    /**
     * @param Integer[][] $board
     * @return NULL
     */
    public $row;
    public $column;
    
    function gameOfLife(&$board) {
        $this->row = count($board);
        $this->column = count($board[0]);
        
        $newBoard = [];
        for($row=0; $row < $this->row; $row++){
            for($column = 0 ; $column  < $this->column; $column++){
                $live = 0;
                $die = 0;
             
                foreach($this->neighbors($column,$row) as $neighbor){
                    if(!$this->isAvailable($neighbor[0], $neighbor[1])){
                        continue;   
                    }
                    $board[$neighbor[1]][$neighbor[0]] == 1?$live++ : $die++;
                }
                if($live > 3){
                    $newBoard[$row][$column] = 0;
                } elseif($live == 3){
                    $newBoard[$row][$column] = 1;
                } elseif($live < 2){
                    $newBoard[$row][$column] = 0;
                } else{
                    $newBoard[$row][$column] = $board[$row][$column];    
                }
                
            }
        }
        $board = $newBoard;
    }
    
    function isAvailable($column, $row){
        if($column >= $this->column){
            return false;
        }
        if($row >= $this->row){
            return false;
        }
        if($row < 0 || $column < 0){
            return false;
        }
        
        return true;
    }
    
    function neighbors($column, $row){
        return [
            [$column - 1, $row + 1], // 왼쪽 위
            [$column , $row + 1 ],
            [$column + 1, $row + 1],
            [$column - 1, $row],
            [$column + 1, $row],
            [$column - 1, $row - 1],
            [$column , $row - 1],
            [$column  + 1, $row - 1],
        ];
    }
}