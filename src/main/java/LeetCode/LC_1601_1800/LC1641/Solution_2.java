package LeetCode.LC_1601_1800.LC1641;

/**
 * Solution 2: DP.
 */
public class Solution_2 {
    public int countVowelStrings(int n) {
        int[][] dp = new int[n+1][6];
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<6; j++) {
                if(i == 1) {
                    dp[i][j] = dp[i][j-1] + 1;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[n][5];
    }
}
