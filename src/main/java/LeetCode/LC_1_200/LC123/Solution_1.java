package LeetCode.LC_1_200.LC123;

/**
 * Solution 1: regular DP, causing TLE.
 */
public class Solution_1 {
    public int maxProfit(int[] prices) {
        int K=2; // at most 2 transactions.
        int[][] dp = new int[prices.length][K+1];
        for(int k=1; k<=K; k++) {
            for(int i=1; i<prices.length; i++) {
                int profit = 0;
                for(int j=0; j<=i; j++) { // buy stock at jth day.
                    if(j == 0) {
                        profit = Math.max(profit, prices[i] - prices[j]);
                    } else {
                        profit = Math.max(profit, prices[i] - prices[j] + dp[j-1][k-1]);
                    }
                }
                dp[i][k] = Math.max(dp[i-1][k], profit);
            }
        }
        return dp[prices.length-1][2];
    }
}
