/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
var nextGreaterElement = function(nums1, nums2) {
    return nums1.map(function(num){
        let i = nums2.indexOf(num) + 1;
        if(i === nums2.length){
            return -1;
        }
        for(;i < nums2.length; i++){
            if(nums2[i] > num){
                return nums2[i];
            }
        }
        
        return -1;
    })
};