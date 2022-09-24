/**
 * @param {number[]} nums
 * @return {boolean}
 */
var canJump = function(nums) {
    let limit = nums[0];
    for(const [index, num] of nums.entries()){
        if(index > limit){
            return false;
        }
        
        limit = Math.max(limit, index + num);
        
        if(limit >= nums.length -1){
            return true;
        }
    }
    return true;
};