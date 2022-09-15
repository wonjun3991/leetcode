/**
 * @param {number[]} nums
 * @return {number}
 */
var firstMissingPositive = function(nums) {
    let i = 1;
    nums.filter((num)=> num > 0).sort((a,b)=> a-b).forEach(function(num){
        if(num !== i){
            return i;
        }
        i = num + 1;
    });
    return i;
};