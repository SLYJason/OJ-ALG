package LeetCode.DynamicProgramming;

/**
 * Solution: DP.
 * dp[i][j]: max sub sequence of [i, j].
 * s.charAt(i) == s.charAt(j): dp[i][j] = 2 + dp[i+1][j-1];
 * s.charAt(i) != s.charAt(j): dp[i][j] = max(dp[i+1][j], dp[i][j-1]);
 */
public class LeetCode516 {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        // base case
        for(int i=0; i<s.length(); i++) {
            dp[i][i] = 1;
        }
        for(int i=s.length()-1; i>=0; i--) {
            for(int j=i+1; j<s.length(); j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i+1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][s.length()-1];
    }
}
