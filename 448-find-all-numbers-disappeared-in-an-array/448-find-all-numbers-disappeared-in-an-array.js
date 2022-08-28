/**
 * @param {number[]} nums
 * @return {number[]}
 */
var findDisappearedNumbers = function(nums) {
    const list = [];
    const disappearedList = [];
    
    for(num of nums){
        list.push(num)
    }
    
    for(let i =1; i < nums.length + 1; i++){
        if(!list.includes(i)){
            disappearedList.push(i);
        }
    }
    return disappearedList
};