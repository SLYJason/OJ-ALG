package LeetCode.LC_1_200.LC159;

import java.util.Map;
import java.util.HashMap;

/**
 * Solution 1: Sliding Window v1.
 */
public class Solution_1 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length() <= 2) return s.length();
        int max_length = 0;
        Map<Character, Integer> map = new HashMap();
        for(int i=0, j=0; j<s.length(); j++) {
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            if(map.size() <= 2) {
                max_length = Math.max(max_length, j-i+1);
            } else {
                char removed = s.charAt(i);
                map.put(removed, map.get(removed)-1);
                if(map.get(removed) == 0) map.remove(removed);
                i++;
            }
        }
        return max_length;
    }
}
