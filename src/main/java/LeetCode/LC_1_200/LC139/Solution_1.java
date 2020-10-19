package LeetCode.LC_1_200.LC139;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

/**
 * Solution 1: brute force recursion, causing TLE.
 * Time Complexity: O(2^n)
 * Space Complexity: O(n)
 */
public class Solution_1 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet(wordDict);
        return wb(s, dict);
    }

    private boolean wb(String s, Set<String> dict) {
        if(s.length() == 0) return true;
        for(int i=0; i<=s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i);
            if(dict.contains(left) && wb(right, dict)) return true;
        }
        return false;
    }
}
