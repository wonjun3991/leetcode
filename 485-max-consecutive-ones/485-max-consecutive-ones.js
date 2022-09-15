/**
 * @param {number[]} nums
 * @return {number}
 */
var findMaxConsecutiveOnes = function(nums) {
    const countList = [];
    let count = 0;
    nums.forEach(function(num){
      if(num === 0){
            countList.push(count);
            count = 0;
        } else if(num === 1){
            count = count + 1;
        }  
    });
    countList.push(count);
    return Math.max(...countList);
};