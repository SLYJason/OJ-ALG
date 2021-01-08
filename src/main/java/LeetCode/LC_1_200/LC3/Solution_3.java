package LeetCode.LC_1_200.LC3;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
/**
 * Solution 3: sliding window hashmap optimized.
 */
public class Solution_3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i=0, j=0; j<s.length(); ++j){
            if (map.containsKey(s.charAt(j))){
                i = Math.max(i, map.get(s.charAt(j)) + 1); // to see why max here, consider 'abba' for example.
            }
            map.put(s.charAt(j), j);
            max = Math.max(max, j - i + 1);
        }
        return max;
    }
}
