class Solution {
function combinationSum($candidates, $target) {
        $out=[]; //保存一个解
        $res=[]; //所有解
       $this->helper($candidates,$target,0,$out,$res);
       return $res;
    }
    function helper($candidates,$target,$index,&$out,&$res){
        if($target<0) return ;
        if($target==0) {
             array_push($res,$out);
            return ;
        }
        for($i=$index;$i<count($candidates);$i++){
            array_push($out,$candidates[$i]);
            $this->helper($candidates,$target-$candidates[$i],$i,$out,$res);
            array_pop($out);
        }
    }
}