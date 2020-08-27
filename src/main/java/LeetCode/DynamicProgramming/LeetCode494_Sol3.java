package LeetCode.DynamicProgramming;

import java.util.Arrays;

/**
 * Solution 3: 2D DP.
 * Recurrence relation: dp[i][j] = dp[i-1][j-num[i]] + dp[i-1][j+num[i]].
 */
public class LeetCode494_Sol3 {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = Arrays.stream(nums).sum();
        // dp[i][j]: numer of ways that the first i index sum to j
        if(S > sum) return 0;
        int[][] dp = new int[nums.length+1][2*sum+1];
        dp[0][sum] = 1;
        for(int i=1; i<nums.length+1; i++) {
            for(int j=0; j<2*sum+1; j++) {
                if(j - nums[i-1] >= 0) dp[i][j] += dp[i-1][j-nums[i-1]];
                if(j + nums[i-1] < 2*sum+1) dp[i][j] += dp[i-1][j+nums[i-1]];
            }
        }
        return dp[nums.length][sum+S];
    }
}
