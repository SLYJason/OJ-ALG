package LeetCode.LC_1601_1800.LC1641;

/**
 * Solution 2: DP.
 * When j = 1: use u only.
 * When j = 2: use o, u only.
 * When j = 3: use i, o, u only.
 * When j = 4: use e, i, o, u only.
 * When j = 5: use a, e, i, o, u only.
 */
public class Solution_2 {
    public int countVowelStrings(int n) {
        int[][] dp = new int[n+1][6]; // dp[i][j] means number of ways of using the first j vowels to get string with length i.
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
