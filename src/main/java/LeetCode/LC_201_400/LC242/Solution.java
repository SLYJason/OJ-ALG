package LeetCode.LC_201_400.LC242;

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] array = new int[26];
        for(char ch : s.toCharArray()) array[ch - 'a']++;
        for(char ch : t.toCharArray()) {
            if (--array[ch - 'a'] < 0) return false;
        }
        return true;
    }
}
