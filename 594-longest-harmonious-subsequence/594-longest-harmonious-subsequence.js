/**
 * @param {number[]} nums
 * @return {number}
 */
var findLHS = function(nums) {
    const dict = {};
    nums.sort((a, b) => a - b).forEach((num) => dict[num] !== undefined ? dict[num] = dict[num] + 1 : dict[num] = 1);
    
    let keyList = Object.keys(dict).sort((a, b) => a - b);
    let prevKey = keyList[0];
    let count = 0;
    
    for (const key of keyList) {
        if(key === prevKey){
            continue;
        }
        
        
        if(key - prevKey === 1){
            count = Math.max(count, dict[prevKey] + dict[key]);
        }
        
        prevKey = key;
    }
    return count;
};