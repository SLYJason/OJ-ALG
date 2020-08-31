package LeetCode.DynamicProgramming;

/**
 * Solution 2: DP
 */
public class LeetCode647_Sol2 {
    public int countSubstrings(String s) {
        int count = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i=s.length()-1; i>=0; i--) {
            for(int j=i; j<s.length(); j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    // tricks here:
                    // i == j: single character, e.g. "a"
                    // i + 1 == j: only need to check s.charAt(i) == s.charAt(j), e.g. "aa"
                    // i + 2 == j: only need to check s.charAt(i) == s.charAt(j), e.g. "aba"
                    dp[i][j] = i+2 >= j ? true : dp[i+1][j-1];
                }
                if(dp[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
