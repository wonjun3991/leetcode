/**
 * @param {number[]} nums
 * @param {number} val
 * @return {number}
 */
var removeElement = function(nums, val) {
    const onlyNums = nums.filter((num)=>num!=val);
    const removeVals = nums.filter((num)=>num==val).map((num)=>"_");
    
    nums.splice(0,nums.length, ...onlyNums.concat(removeVals));
    
    return onlyNums.length;
};