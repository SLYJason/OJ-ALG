package LeetCode.LC_401_600.LC438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution 3: sliding window - array.
 */
public class Solution_3 {
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || p == null || s.length() < p.length()) return new ArrayList<>();

        List<Integer> ans = new ArrayList<>();
        int[] pCount = new int[26];
        int[] sCount = new int[26];
        for (char ch : p.toCharArray()) {
            pCount[ch - 'a']++;
        }
        for (int i = 0; i<s.length(); i++) {
            char ch = s.charAt(i);
            sCount[ch - 'a']++;
            if (i >= p.length()) {
                char removed = s.charAt(i - p.length());
                sCount[removed - 'a']--;
            }
            if (Arrays.equals(pCount, sCount)) ans.add(i - p.length() + 1);
        }
        return ans;
    }
}
