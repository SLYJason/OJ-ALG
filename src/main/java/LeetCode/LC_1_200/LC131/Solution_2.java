package LeetCode.LC_1_200.LC131;

import java.util.List;
import java.util.ArrayList;

/**
 * Solution 2: backtrack + DP.
 * N is the length of s.
 * Time Complexity: O(N^2 + 2^N) = O(2^N). N^2 comes from dp array generation.
 * Space Complexity: O(N^2). We need dp array.
 */
public class Solution_2 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList();
        boolean[][] dp = new boolean[s.length()][s.length()]; // dp[start][end] means substring[start, end] is palindrome or not.
        for(int end=0; end<s.length(); end++) {
            for(int start=0; start<=end; start++) {
                if(s.charAt(start) == s.charAt(end) && (end-start <= 2 || dp[start+1][end-1])) {
                    dp[start][end] = true;
                }
            }
        }
        dfs(0, s, new ArrayList(), res, dp);
        return res;
    }

    private void dfs(int pos, String s, List<String> list, List<List<String>> res, boolean[][] dp) {
        if(pos == s.length()) {
            res.add(new ArrayList(list));
            return;
        }
        for(int i=pos; i<s.length(); i++) {
            if(dp[pos][i]) {
                list.add(s.substring(pos, i+1));
                dfs(i+1, s, list, res, dp);
                list.remove(list.size()-1);
            }
        }
    }
}
