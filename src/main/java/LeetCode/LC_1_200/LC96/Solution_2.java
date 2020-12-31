package LeetCode.LC_1_200.LC96;

/**
 * Solution 2: DP concise.
 */
public class Solution_2 {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        for(int i=2; i<=n; i++) {
            for(int root=1; root<=i; root++) {
                dp[i] += dp[root-1] * dp[i-root];
            }
        }
        return dp[n];
    }
}
