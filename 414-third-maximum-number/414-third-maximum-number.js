/**
 * @param {number[]} nums
 * @return {number}
 */
var thirdMax = function(nums) {
    let unique = [...new Set(nums)].sort((a, b) => (a > b ? -1 : 1));
    console.log(unique)
    if(unique.length < 3){
        return unique[0]
    }
    return unique[2]
};