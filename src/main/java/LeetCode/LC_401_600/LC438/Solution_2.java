package LeetCode.LC_401_600.LC438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution 2: sliding window using - hashmap.
 */
public class Solution_2 {
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || p == null || s.length() < p.length()) return new ArrayList<>();

        List<Integer> ans = new ArrayList<>();
        Map<Character, Integer> pCount = new HashMap<>();
        Map<Character, Integer> sCount = new HashMap<>();
        for (char ch : p.toCharArray()) {
            pCount.put(ch, pCount.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            sCount.put(ch, sCount.getOrDefault(ch, 0) + 1);
            if (i >= p.length()) {
                char removed = s.charAt(i - p.length());
                if (sCount.get(removed) == 1) {
                    sCount.remove(removed);
                } else {
                    sCount.put(removed, sCount.get(removed)-1);
                }
            }
            if (pCount.equals(sCount)) ans.add(i - p.length() + 1);
        }
        return ans;
    }
}
