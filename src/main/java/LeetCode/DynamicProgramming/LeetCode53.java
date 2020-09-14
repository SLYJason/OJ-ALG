package LeetCode.DynamicProgramming;

public class LeetCode53 {
    // DP solution: Kadane's algorithm
    // maxSubArray(nums, i) = (maxSubArray(nums, i - 1) > 0 ? maxSubArray(nums, i - 1) : 0) + nums[i];
    // Time Complexity: O(N)
    // Space Complexity: O(N)
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

    // DP solution: Kadane's algorithm, space optimal solution
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int maxSubArray2(int[] nums) {
        int max_ending_here = nums[0];
        int max_so_far = nums[0];
        for(int i=1; i<nums.length; i++) {
            max_ending_here = Math.max(max_ending_here + nums[i], nums[i]);
            max_so_far = Math.max(max_ending_here, max_so_far);
        }
        return max_so_far;
    }
}
