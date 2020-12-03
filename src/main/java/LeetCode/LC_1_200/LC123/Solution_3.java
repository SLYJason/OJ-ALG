package LeetCode.LC_1_200.LC123;

/**
 * Solution 3: Optimized DP.
 */
public class Solution_3 {
    public int maxProfit(int[] prices) {
        int K=2; // at most 2 transactions.
        int[][] dp = new int[prices.length][K+1];
        for(int k=1; k<=K; k++) {
            int min = prices[0];
            for(int i=1; i<prices.length; i++) {
                min = Math.min(min, prices[i] - dp[i-1][k-1]);
                dp[i][k] = Math.max(dp[i-1][k], prices[i] - min);
            }
        }
        return dp[prices.length-1][2];
    }
}
