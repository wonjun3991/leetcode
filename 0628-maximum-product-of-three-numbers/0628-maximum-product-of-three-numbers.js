/**
 * @param {number[]} nums
 * @return {number}
 */
var maximumProduct = function(nums) {
    const list = nums.sort((a,b)=>a-b);
    return Math.max(list[0] * list[1] * list[list.length-1], list[list.length -1] * list[list.length-2] * list[list.length-3]);
};