package LeetCode.LC_1_200.LC132;

import java.util.Arrays;
/**
 * Solution: DP.
 */
public class Solution {
    public int minCut(String s) {
        if(s.length() <= 1) return 0;
        // Step 1: pre-processing.
        boolean[][] valid = new boolean[s.length()][s.length()]; // valid[start][end] means substring[start, end] is palindrome or not.
        for(int end=0; end<s.length(); end++) {
            for(int start=0; start<=end; start++) {
                if(s.charAt(start) == s.charAt(end) && (end - start <= 2 || valid[start+1][end-1])) {
                    valid[start][end] = true;
                }
            }
        }
        // Step 2: find the minimum cuts needed.
        int[] dp = new int[s.length()]; // dp[i] means minimum cuts needed for substring [0, i];
        Arrays.fill(dp, s.length()-1); // the maximum cut is s.length()-1.
        for(int i=0; i<s.length(); i++) {
            if(valid[0][i]) {
                dp[i] = 0; // base case: if substring [0, i] is palindrome, 0 cuts needed.
                continue;
            }
            for(int j=0; j<i; j++) {
                if(valid[j+1][i]) {
                    dp[i] = Math.min(dp[i], dp[j]+1);
                }
            }
        }
        return dp[s.length()-1];
    }
}
