package LeetCode.LC_1_200.LC53;

/**
 * Solution 1: DP.
 * Recurrence Relations: dp[i] means maximum sum ending num[i] (inclusive).
 * dp[i]:
 * if dp[i-1] < 0, means we have to start over to calculate the maximum, i.e. dp[i] = nums[i].
 * if dp[i-1] > 0, means we can use previous calculated maximum to get current maximum sum, i.e. dp[i] = dp[i-1] + nums[i].
 */
public class Solution_1 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxSum = nums[0];
        for(int i=1; i<nums.length; i++) {
            dp[i] = (dp[i-1] > 0 ? dp[i-1] : 0) + nums[i];
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }
}
