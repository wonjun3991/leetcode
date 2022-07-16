class Solution:
    def arrayPairSum(self, nums: List[int]) -> int:
        nums.sort()   
        maximum_sum = 0
        for i in range(0, len(nums), 2):
            maximum_sum += nums[i]
        return maximum_sum