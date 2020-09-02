package LeetCode.String;

import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

public class LeetCode438 {
    /**
     * Solution: Sliding Window
     */
    public List<Integer> findAnagrams(String s, String p) {
        if(p.length() > s.length()) return new LinkedList();
        List<Integer> res = new LinkedList();
        int[] pCount = new int[26];
        int[] subCount = new int[26];
        for(char ch : p.toCharArray()) pCount[ch-'a']++;
        for(int i=0; i<s.length(); i++) {
            subCount[s.charAt(i)-'a']++;
            if(i >= p.length()) subCount[s.charAt(i-p.length())-'a']--;
            if(Arrays.equals(subCount, pCount)) res.add(i-p.length()+1);
        }
        return res;
    }
}
