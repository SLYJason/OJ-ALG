package LeetCode.LC_201_400.LC205;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Character> map = new HashMap();
        Set<Character> set = new HashSet();
        for(int i=0; i<s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            if(map.containsKey(ch1)) {
                if(map.get(ch1) != ch2) return false; // ch1 it already mapped to ch2.
            } else {
                if(set.contains(ch2)) return false; // ch2 already by another one.
                map.put(ch1, ch2);
                set.add(ch2);
            }
        }
        return true;
    }
}