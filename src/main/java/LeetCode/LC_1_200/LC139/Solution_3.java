package LeetCode.LC_1_200.LC139;

import java.util.List;

/**
 * Solution 3: DP.
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 */
public class Solution_3 {
    public boolean wordBreak(String s, List<String> wordDict) {
        // dp[i] means the first i characters of s can be split
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true; // base case
        for(int i=1; i<=s.length(); i++) {
            for(int j=0; j<i; j++) {
                if(dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
