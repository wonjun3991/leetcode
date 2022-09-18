/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var nextPermutation = function (nums) {
  let standIndex = -1;
  let changeIndex = 0;

  for (let i = 0; i < nums.length - 1; i++) {
    if (nums[i] < nums[i + 1]) {
      standIndex = i;
      changeIndex = i + 1;
    }
    if (nums[changeIndex] >= nums[i + 1] && nums[standIndex] < nums[i + 1]) {
      changeIndex = i + 1;
    }
  }

  if (standIndex !== -1) {
    swap(nums, standIndex, changeIndex);
  }

  let i = standIndex + 1;
  let j = nums.length - 1;
  while (i < j) {
    swap(nums, i, j);
    i++;
    j--;
  }
};

const swap = (nums, a, b) => {
  let temp = nums[a];
  nums[a] = nums[b];
  nums[b] = temp;
};