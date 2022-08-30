/**
 * @param {number[]} score
 * @return {string[]}
 */
var findRelativeRanks = function(score) {
    const map = new Map()
    
    const rankList = [...score].sort((a, b) => (a > b ? -1 : 1))
    
    for(let i = 0; i< rankList.length; i++){
        if(i === 0){
            map.set(rankList[i],"Gold Medal");
            continue;
        }
        if(i === 1){
            map.set(rankList[i],"Silver Medal");
            continue;
        }
        if(i === 2){
            map.set(rankList[i],"Bronze Medal");
            continue;
        }
        map.set(rankList[i],`${i+1}`)
    }
    console.log(map)
    console.log(score)
    
    return score.map((score)=>map.get(score))
};