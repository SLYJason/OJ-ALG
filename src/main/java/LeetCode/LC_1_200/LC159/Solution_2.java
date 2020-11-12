package LeetCode.LC_1_200.LC159;

import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

/**
 * Solution 2: Sliding Window v2.
 */
public class Solution_2 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length() <= 2) return s.length();
        int max_length = 0;
        Map<Character, Integer> map = new HashMap();
        int left = 0, right = 0;
        while(right < s.length()) {
            map.put(s.charAt(right), right++);
            if(map.size() > 2) {
                int remove_idx = Collections.min(map.values());
                map.remove(s.charAt(remove_idx));
                left = remove_idx + 1;
            }
            max_length = Math.max(max_length, right-left);
        }
        return max_length;
    }
}
