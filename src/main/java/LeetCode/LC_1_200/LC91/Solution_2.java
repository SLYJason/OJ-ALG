package LeetCode.LC_1_200.LC91;

/**
 * Solution 2: DP.
 */
public class Solution_2 {
    public int numDecodings(String s) {
        if(s.length() == 0) return 0;
        int[] dp = new int[s.length()+1];
        dp[0] = 1; // tricks here.
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for(int i=2; i<s.length()+1; i++) {
            int one_digit = Integer.parseInt(s.substring(i-1, i));
            int two_digit = Integer.parseInt(s.substring(i-2, i));
            if(one_digit >= 1 && one_digit <= 9) {
                dp[i] += dp[i-1];
            }
            if(two_digit >= 10 && two_digit <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()];
    }
}
