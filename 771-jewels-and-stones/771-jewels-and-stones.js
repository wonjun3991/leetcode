/**
 * @param {string} jewels
 * @param {string} stones
 * @return {number}
 */
var numJewelsInStones = function(jewels, stones) {
    let count = 0;
    for(stone of stones){
        for(jewel of jewels){
            if(jewel == stone){
                count = count + 1;
                break;
            }
        }
    }
    return count
};