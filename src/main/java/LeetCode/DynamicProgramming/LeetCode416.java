package LeetCode.DynamicProgramming;

public class LeetCode416 {
    // TODO: how to optimize the space
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum % 2 != 0) return false;
        sum /= 2;
        // dp[i][j] means whether the sum j can be gotten from the first i numbers
        boolean[][] dp = new boolean[nums.length+1][sum+1];
        // Initialization
        for(int i=0; i<nums.length+1; i++) {
            dp[i][0] = true;
        }
        // DP procedures
        for(int i=1; i<nums.length+1; i++) {
            for(int j=1; j<sum+1; j++) {
                if(j >= nums[i-1]) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[nums.length][sum];
    }
}
