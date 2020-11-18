package LeetCode.LC_1_200.LC10;

public class Solution {
    public boolean isMatch(String s, String p) {
        int len1 = s.length(), len2 = p.length();
        boolean[][] dp = new boolean[len1+1][len2+1];
        dp[0][0] = true;
        // Initialization.
        for(int i=1; i<len2+1; i++) {
            if(p.charAt(i-1) == '*' && dp[0][i-2]) { // e.g.: "" matches "a*"
                dp[0][i] = true;
            }
        }

        // DP
        for (int i=1; i<len1+1; i++) {
            for (int j=1; j<len2+1; j++) {
                char ch1 = s.charAt(i-1);
                char ch2 = p.charAt(j-1);
                if (ch1 == ch2 || ch2 == '.') { // Case 1 & 2.
                    dp[i][j] = dp[i-1][j-1];
                }
                if (ch2 == '*') { // Case 3.
                    dp[i][j] = dp[i][j-2] || ((p.charAt(j-2) == ch1 || p.charAt(j-2) == '.') && dp[i-1][j]);
                }
            }
        }
        return dp[len1][len2];
    }
}
