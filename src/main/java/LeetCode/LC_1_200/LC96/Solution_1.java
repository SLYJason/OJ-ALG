package LeetCode.LC_1_200.LC96;

/**
 * Solution 1: DP verbose.
 */
public class Solution_1 {
    public int numTrees(int n) {
        if(n == 1) return 1;
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i=2; i<=n; i++) {
            int total = 0;
            for(int root=1; root<=i; root++) {
                int left = root - 1, right = i - root;
                if(left == 0) {
                    total += dp[right];
                } else if(right == 0) {
                    total += dp[left];
                } else {
                    total += dp[left] * dp[right];
                }
            }
            dp[i] = total;
        }
        return dp[n];
    }
}
