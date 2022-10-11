package LeetCode.LC_401_600.LC438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution 1: brute force.
 */
public class Solution_1 {
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || p == null || s.length() < p.length()) return new ArrayList<> ();

        List<Integer> list = new ArrayList<>();
        int[] expected = new int[26];
        for (char ch : p.toCharArray()) {
            expected[ch - 'a']++;
        }
        for (int i = 0; i <= s.length() - p.length(); i++) {
            String sub = s.substring(i, i + p.length());
            int[] actual = new int[26];
            for (char ch : sub.toCharArray()) {
                actual[ch - 'a']++;
            }
            if (Arrays.equals(expected, actual)) list.add(i);
        }
        return list;
    }
}
