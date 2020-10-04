package LeetCode.LC_1_200.LC3;

import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Solution 1: brute force, intuitive thoughts, caused TLE.
 * Time Complexity: O(N^3).
 * Space Complexity: O(N), worst case.
 * Find every substring and check it one by one.
 */
public class Solution_1 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 || s.length() == 1) return s.length();
        int res = 0;
        for(int i=0; i<s.length(); i++) {
            for(int j=i+1; j<=s.length(); j++) {
                String sub = s.substring(i, j);
                List<Character> list = sub.chars().mapToObj(c -> (char)c).collect(Collectors.toList());
                Set<Character> set = new HashSet(list);
                if(set.size() == sub.length()) {
                    res = Math.max(res, sub.length());
                }
            }
        }
        return res;
    }
}
