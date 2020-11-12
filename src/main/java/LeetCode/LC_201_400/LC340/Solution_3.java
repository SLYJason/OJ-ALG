package LeetCode.LC_201_400.LC340;

import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
/**
 * Solution 3: Sliding Window v3, using LC159 Solution_2 same logic.
 */
public class Solution_3 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k == 0) return 0;
        if(s.length() == 0 || s.length() == 1) return s.length();
        Map<Character, Integer> map = new HashMap(); // K: char ch inside of s, V: last of appearance index of char.
        int i=0, j=0, max=0;
        while(j < s.length()) {
            char ch = s.charAt(j);
            map.put(ch, j++);
            if(map.size() > k) {
                int dele = Collections.min(map.values());
                map.remove(s.charAt(dele));
                i = dele + 1;
            }
            max = Math.max(max, j-i);
        }
        return max;
    }
}
