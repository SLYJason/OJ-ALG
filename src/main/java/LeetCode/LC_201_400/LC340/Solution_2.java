package LeetCode.LC_201_400.LC340;

import java.util.Map;
import java.util.HashMap;
/**
 * Solution 2: sliding window.
 */
public class Solution_2 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k == 0) return 0;
        if(s.length() == 0 || s.length() == 1) return s.length();
        Map<Character, Integer> map = new HashMap(); // K: char ch inside of s, V: # of appearances  of char.
        int i=0, j=0, max=0;
        while(j < s.length()) {
            char ch = s.charAt(j++);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            while(map.size() > k) { // move sliding window left pointer.
                char leftChar = s.charAt(i++);
                map.put(leftChar, map.get(leftChar)-1);
                if(map.get(leftChar) == 0) map.remove(leftChar);
            }
            max = Math.max(max, j-i);
        }
        return max;
    }
}

