package LeetCode.LC_201_400.LC343;

/**
 * Solution 1: DP.
 */
public class Solution_1 {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        for(int i=2; i<n+1; i++) {
            for(int j=1; j<i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i-j), dp[j] * (i-j)));
            }
        }
        return dp[n];
    }
}
