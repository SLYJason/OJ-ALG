package LeetCode.DynamicProgramming;

/**
 * Solution 2: DP.
 */
public class LeetCode5_Sol2 {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        String max_string = "";
        for(int i=s.length()-1; i>=0; i--) {
            for(int j=i; j<s.length(); j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = i + 2 >= j ? true : dp[i+1][j-1];
                    if(dp[i][j] && j-i+1>max_string.length()) {
                        max_string = s.substring(i, j+1);
                    }
                }
            }
        }
        return max_string;
    }
}
