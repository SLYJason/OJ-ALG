package LeetCode.LC_1_200.LC3;

import java.util.Map;
import java.util.HashMap;

/**
 * Solution 1: sliding window hashmap.
 */
public class Solution_1 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();
        char[] S = s.toCharArray();
        int i = 0, j = 0, max_length = 0;
        Map<Character, Integer> window = new HashMap<>();
        while (j < s.length()) {
            char rc = S[j++]; // right char.
            window.put(rc, window.getOrDefault(rc, 0) + 1);
            while (window.size() != j - i) { // contract the window.
                char lc = S[i]; // left char.
                window.put(lc, window.get(lc) - 1);
                if (window.get(lc) == 0) window.remove(lc);
                i++;
            }
            max_length = Math.max(max_length, j - i);
        }
        return max_length;
    }
}
