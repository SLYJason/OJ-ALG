package LeetCode.LC_1_200.LC72;

/**
 * Solution: DP.
 */
public class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i=0; i<word1.length()+1; i++) {
            for(int j=0; j<word2.length()+1; j++) {
                if(i == 0 && j == 0) {
                    dp[i][j] = 0;
                } else if(i == 0) {
                    dp[i][j] = j;
                } else if(j == 0) {
                    dp[i][j] = i;
                } else {
                    if(word1.charAt(i-1) == word2.charAt(j-1)) {
                        dp[i][j] = dp[i-1][j-1];
                    } else {
                        // insert dp[i][j-1]
                        // delete dp[i-1][j]
                        // replace dp[i-1][j-1]
                        dp[i][j] = 1 + Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]);
                    }
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
