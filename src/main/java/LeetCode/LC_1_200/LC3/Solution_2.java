package LeetCode.LC_1_200.LC3;

import java.util.Set;
import java.util.HashSet;

/**
 * Solution 2: sliding window hashset.
 */
public class Solution_2 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();
        char[] S = s.toCharArray();
        int i = 0, j = 0, max_length = 0;
        Set<Character> window = new HashSet<>();
        while (j < s.length()) {
            if (!window.contains(S[j])) {
                window.add(S[j++]);
                max_length = Math.max(max_length, j - i);
            } else {
                window.remove(S[i++]);
            }
        }
        return max_length;
    }
}
