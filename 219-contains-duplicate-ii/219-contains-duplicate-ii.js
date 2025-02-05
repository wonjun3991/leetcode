/**
 * @param {number[]} nums
 * @param {number} k
 * @return {boolean}
 */
var containsNearbyDuplicate = function(nums, k) {
    const arr = []
    for(const [index, num] of nums.entries()){
        if(arr.includes(num)){
            return true;
        }
        arr.push(num);
        if(arr.length > k){
            arr.splice(0, 1)
        }
        
    }
    return false;
};