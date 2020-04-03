package LeetCode;

// DP solution: Kadane's algorithm
// maxSubArray(nums, i) = (maxSubArray(nums, i - 1) > 0 ? maxSubArray(nums, i - 1) : 0) + nums[i];
// Time Complexity: O(N)
// Space Complexity: O(N)
public class LeetCode53 {
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
