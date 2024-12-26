public class Solution {

    // Tracks the total number of ways to reach the target
    int totalWays = 0;

    public int findTargetSumWays(int[] nums, int target) {
        calculateWays(nums, 0, 0, target);
        return totalWays;
    }

    private void calculateWays(
        int[] nums,
        int currentIndex,
        int currentSum,
        int target
    ) {
        if (currentIndex == nums.length) {
            // Check if the current sum matches the target
            if (currentSum == target) {
                totalWays++;
            }
        } else {
            // Include the current number with a positive sign
            calculateWays(
                nums,
                currentIndex + 1,
                currentSum + nums[currentIndex],
                target
            );
            // Include the current number with a negative sign
            calculateWays(
                nums,
                currentIndex + 1,
                currentSum - nums[currentIndex],
                target
            );
        }
    }
}