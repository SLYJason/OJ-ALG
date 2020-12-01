package LeetCode.LC_1_200.LC5;

/**
 * Solution 1: DP.
 */
public class Solution_1 {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int index = 0, max_length = Integer.MIN_VALUE;
        for(int end=0; end<s.length(); end++) {
            for(int start=0; start<=end; start++) {
                if(s.charAt(start) == s.charAt(end) && (end-start <= 2 || dp[start+1][end-1])) {
                    dp[start][end] = true;
                }
                if(dp[start][end] && end - start + 1 > max_length) {
                    max_length = end - start + 1;
                    index = start;
                }
            }
        }
        return s.substring(index, index + max_length);
    }
}
