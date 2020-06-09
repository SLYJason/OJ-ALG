package LeetCode.DynamicProgramming;

public class LeetCode518 {
    // TODO: how to optimize the space
    public int change(int amount, int[] coins) {
        // dp[i][j]: the number of combinations to make up amount j by using the first i types of coins
        int[][] dp = new int[coins.length+1][amount+1];
        // Base case
        for(int i=0; i<coins.length+1; i++) {
            dp[i][0] = 1;
        }
        for(int i=1; i<coins.length+1; i++) {
            for(int j=1; j<amount+1; j++) {
                if(j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[coins.length][amount];
    }
}
