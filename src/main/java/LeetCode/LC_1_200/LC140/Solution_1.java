package LeetCode.LC_1_200.LC140;

import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

/**
 * Solution 1: brute force, causing TLE.
 */
public class Solution_1 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new LinkedList();
        wb(s, new HashSet(wordDict), "", ans);
        return ans;
    }

    private void wb(String s, Set<String> dict, String combined, List<String> ans) {
        if(s.length() == 0) {
            ans.add(combined.trim());
            return;
        }
        for(int i=0; i<=s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i);
            if(dict.contains(left)) {
                combined += left + " ";
                wb(right, dict, combined, ans);
                combined = combined.substring(0, combined.length()-left.length()-1); // backtrack.
            }
        }
    }
}
