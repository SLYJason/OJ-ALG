package LeetCode.DynamicProgramming;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

/**
 * Solution 1: brute force recursion, causing TLE.
 * Time Complexity: O(2^n)
 * Space Complexity: O(n)
 */
public class LeetCode139_Sol1 {
    public boolean wordBreak(String s, List<String> wordDict) {
        return wb(s, new HashSet(wordDict));
    }

    private boolean wb(String s, Set<String> dict) {
        if(s.length() == 0) return true;
        for(int i=0; i<=s.length(); i++) {
            if(dict.contains(s.substring(0, i)) && wb(s.substring(i), dict)) {
                return true;
            }
        }
        return false;
    }
}
