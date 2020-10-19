package LeetCode.LC_1_200.LC139;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

/**
 * Solution 2: brute force recursion with memorization.
 * Time Complexity: O(n^2), only need to check n*(n+1)/2 unique strings, i.e. O(n^2)
 * Space Complexity: O(n^2).
 */
public class Solution_2 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> memo = new HashMap();
        Set<String> dict = new HashSet(wordDict);
        return wb(s, dict, memo);
    }

    private boolean wb(String s, Set<String> dict, Map<String, Boolean> memo) {
        if(s.length() == 0) return true;
        if(memo.containsKey(s)) return memo.get(s);
        for(int i=0; i<=s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i);
            if(dict.contains(left) && wb(right, dict, memo)) {
                memo.put(right, true);
                return true;
            }
        }
        memo.put(s, false);
        return false;
    }
}
