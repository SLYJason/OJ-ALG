package LeetCode.LC_1_200.LC3;

import java.util.Set;
import java.util.HashSet;

/**
 * Solution 2: optimized brute force.
 * Time Complexity: O(N^2).
 * Space Complexity: O(N), worst case.
 */
public class Solution_2 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 || s.length() == 1) return s.length();
        int res = 0;
        for(int i=0; i<s.length(); i++) {
            int j=i;
            Set<Character> set = new HashSet();
            while(j<s.length() && !set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                res = Math.max(res, j-i);
            }
        }
        return res;
    }
}
