package LeetCode.LC_1001_1200.LC1143;

/**
 * Solution 2: DP, bottom-up.
 */
public class Solution_2 {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.equals(text2)) return text1.length();
        int[][] dp = new int[text1.length()+1][text2.length()+1]; // dp[i][j]: lcs of text1 with length i and text2 with length j.
        for(int i=1; i<text1.length()+1; i++) {
            for(int j=1; j<text2.length()+1; j++) {
                char ch1 = text1.charAt(i-1);
                char ch2 = text2.charAt(j-1);
                if(ch1 == ch2) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
