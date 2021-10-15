class Solution {

    /**
     * @param Integer[] $prices
     * @return Integer
     */
    function maxProfit($prices) {
        if(count($prices) <= 1 ){
            return 0;
        }
        $sell = 0;
        $prevSell = 0;
        $buy = -55555;
        $prevBuy = 0;
        
        for($i = 0; $i < count($prices);++$i){
            $prevBuy = $buy;
            $buy = max($prevSell - $prices[$i], $prevBuy);
            $prevSell = $sell;
            $sell = max($prevBuy + $prices[$i], $prevSell);
        }
        return $sell;
    }
}