package LeetCode.LC_1_200.LC97;

/**
 * Solution 3: DP.
 */
public class Solution_3 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false; // base case.
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        for(int i=0; i<s1.length()+1; i++) {
            for(int j=0; j<s2.length()+1; j++) {
                if(i == 0 && j == 0) {
                    dp[i][j] = true; // both s1 and s2 are empty, so it can make an empty string s3.
                } else if(i == 0) {
                    dp[i][j] = dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1); // s1 is empty, consider s2 only to make s3.
                } else if(j == 0) {
                    dp[i][j] = dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1); // s2 is empty, consider s1 only to make s3.
                } else {
                    dp[i][j] = dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1) || dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1); // both s1 and s2 are non empty, so consider both possibilities.
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
