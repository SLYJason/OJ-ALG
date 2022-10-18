package LeetCode.LC_1_200.LC44;

/**
 * Solution: DP.
 */
public class Solution_1 {
    public boolean isMatch(String s, String p) {
        int n1 = s.length(), n2 = p.length();
        boolean[][] dp = new boolean[n1 + 1][n2 + 1];
        dp[0][0] = true;
        // step 1: initialization.
        for (int i = 1; i <= n2; i++) {
            if (p.charAt(i - 1) == '*') { // e.g.: "abc" matches "*"
                dp[0][i] = true;
            } else {
                break;
            }
        }

        // step 2: DP.
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                char ch1 = s.charAt(i - 1);
                char ch2 = p.charAt(j - 1);
                if (ch1 == ch2 || ch2 == '?') { // Case 1 & 2.
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (ch2 == '*') { // Case 3.
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        return dp[n1][n2];
    }
}
