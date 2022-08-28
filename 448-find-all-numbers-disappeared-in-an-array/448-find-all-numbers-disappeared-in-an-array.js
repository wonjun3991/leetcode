/**
 * @param {number[]} nums
 * @return {number[]}
 */
var findDisappearedNumbers = function(nums) {
    const map = new Map()
    const disappearedList = [];
    
    for(num of nums){
        map.set(num, '1')
    }
    
    for(let i =1; i < nums.length + 1; i++){
        if(!map.has(i)){
            disappearedList.push(i);
        }
    }
    return disappearedList
};