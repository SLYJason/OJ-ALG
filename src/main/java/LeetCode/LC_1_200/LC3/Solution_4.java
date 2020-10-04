package LeetCode.LC_1_200.LC3;

import java.util.Map;
import java.util.HashMap;

/**
 * Solution 4: optimal solution, sliding window using HashMap.
 */
public class Solution_4 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s.length() == 1) return s.length();
        Map<Character, Integer> map = new HashMap();
        int max = 0;
        for (int i=0, j=0; j<s.length(); ++j){
            if (map.containsKey(s.charAt(j))){
                i = Math.max(i, map.get(s.charAt(j))+1);
            }
            map.put(s.charAt(j),j);
            max = Math.max(max,j-i+1);
        }
        return max;
    }
}
