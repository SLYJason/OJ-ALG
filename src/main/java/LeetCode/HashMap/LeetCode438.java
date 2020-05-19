package LeetCode.HashMap;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class LeetCode438 {
    // Solution 1: Brute force, initial thoughts
    public List<Integer> findAnagrams(String s, String p) {
        if(s == null || s.length() < p.length()) return new ArrayList();
        List<Integer> list = new ArrayList();
        int[] expected = new int[26];
        for(char ch : p.toCharArray()) {
            expected[ch - 'a']++;
        }
        for(int i=0; i<=s.length() - p.length(); i++) {
            String sub = s.substring(i, i+p.length());
            int[] actual = new int[26];
            for(char ch : sub.toCharArray()) {
                actual[ch - 'a']++;
            }
            if(Arrays.equals(expected, actual)) list.add(i);
        }
        return list;
    }

    // Solution 2: sliding window using HashMap
    // Time Complexity: O(Ns + Np)
    // Space Complexity: O(1), since pCount and sCount contain not more than 26 elements
    public List<Integer> findAnagrams2(String s, String p) {
        if(s == null || s.length() < p.length()) return new ArrayList();
        List<Integer> ans = new ArrayList();
        Map<Character, Integer> pCount = new HashMap();
        Map<Character, Integer> sCount = new HashMap();
        for(char ch : p.toCharArray()) {
            pCount.put(ch, pCount.getOrDefault(ch, 0) + 1);
        }
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            sCount.put(ch, sCount.getOrDefault(ch, 0) + 1);
            if(i >= p.length()) {
                char removed = s.charAt(i - p.length());
                if(sCount.get(removed) == 1) {
                    sCount.remove(removed);
                } else {
                    sCount.put(removed, sCount.get(removed)-1);
                }
            }
            if(pCount.equals(sCount)) ans.add(i - p.length() + 1);
        }
        return ans;
    }

    // Solution 3: sliding window using array
    // Time Complexity: O(Ns + Np)
    // Space Complexity: O(1), since pCount and sCount contain not more than 26 elements
    public List<Integer> findAnagrams3(String s, String p) {
        if(s == null || s.length() < p.length()) return new ArrayList();
        List<Integer> ans = new ArrayList();
        int[] pCount = new int[26];
        int[] sCount = new int[26];
        for(char ch : p.toCharArray()) {
            pCount[ch - 'a']++;
        }
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            sCount[ch - 'a']++;
            if(i >= p.length()) {
                char removed = s.charAt(i - p.length());
                sCount[removed - 'a']--;
            }
            if(Arrays.equals(pCount, sCount)) ans.add(i - p.length() + 1);
        }
        return ans;
    }
}
