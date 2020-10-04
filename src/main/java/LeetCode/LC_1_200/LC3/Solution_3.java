package LeetCode.LC_1_200.LC3;

import java.util.Set;
import java.util.HashSet;
/**
 * Solution 3: sliding window using HashSet.
 */
public class Solution_3 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 || s.length() == 1) return s.length();
        int res = 0;
        Set<Character> window = new HashSet();
        for(int i=0, j=0; j<s.length(); j++) {
            char ch = s.charAt(j);
            while(window.contains(ch)) { // remove all chars that has the same current value of ch.
                window.remove(s.charAt(i));
                i++;
            }
            res = Math.max(res, j-i+1);
            window.add(ch);
        }
        return res;
    }

    // Another implementation: same logic.
    public int lengthOfLongestSubstrin2(String s) {
        if(s.length() == 0 || s.length() == 1) return s.length();
        int i=0, j=0, max=0;
        Set<Character> window = new HashSet();
        while(j < s.length()) {
            char cur = s.charAt(j);
            if(!window.contains(cur)) {
                window.add(cur);
                max = Math.max(max, j-i+1);
                j++;
            } else {
                window.remove(s.charAt(i++));
            }
        }
        return max;
    }
}
