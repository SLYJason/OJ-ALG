package LeetCode.Amazon.OA1;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Solution: sliding window.
 */
public class Solution {
    public Set<String> unique(String s, int k) {
        Set<String> res = new LinkedHashSet<>();
        Set<Character> window = new HashSet();
        for(int start=0, end=0; end<s.length(); end++) {
            char ch = s.charAt(end);
            while(window.contains(ch)) { // remove all chars that has the same current value of ch.
                window.remove(s.charAt(start));
                start++;
            }
            window.add(ch);
            if(window.size() == k) {
                res.add(s.substring(start, end+1));
                window.remove(s.charAt(start));
                start++;
            }

        }
        return res;
    }
}
