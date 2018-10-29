package LeetCode;

import java.util.List;
import java.util.LinkedList;

public class LeetCode438 {
    public List<Integer> findAnagrams(String s, String p) {
        List list = new LinkedList<Integer>();
        for(int i=0; i<=s.length()-p.length(); i++) {
            String sub = s.substring(i, i+p.length());
            if (isAnagrams(sub.toLowerCase(), p.toLowerCase())) {
                list.add(i);
            }
        }
        return list;
    }

    private boolean isAnagrams(String sub, String p) {
        int[] charCount = new int[26];
        for(char ch:p.toCharArray()) {
            charCount[ch-'a']++;
        }
        for(char ch:sub.toCharArray()) {
            if (charCount[ch - 'a']-- == 0) {
                return false;
            }
        }
        return true;
    }
}
