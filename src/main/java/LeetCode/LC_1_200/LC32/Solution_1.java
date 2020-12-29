package LeetCode.LC_1_200.LC32;

/**
 * Solution 1: DP.
 */
public class Solution_1 {
    public int longestValidParentheses(String s) {
        if(s.length() < 2) return 0;
        int max_length = 0;
        int[] dp = new int[s.length()];
        char[] S = s.toCharArray();
        for(int i=1; i<S.length; i++) {
            if(S[i] == ')') {
                if(S[i-1] == '(') {
                    dp[i] = i >= 2 ? dp[i-2] + 2 : 2;
                } else if(i-dp[i-1]-1 >= 0 && S[i-dp[i-1]-1] == '(') {
                    dp[i] = 2 + dp[i-1] + (i-dp[i-1]-2 >= 0 ? dp[i-dp[i-1]-2] : 0);
                }
            }
            max_length = Math.max(max_length, dp[i]);
        }
        return max_length;
    }
}
