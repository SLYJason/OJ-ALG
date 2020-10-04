package LeetCode.LC_201_400.LC340;

import java.util.Set;
import java.util.HashSet;
/**
 * Solution 1: brute force, intuitive thoughts, causing TLE.
 */
public class Solution_1 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k == 0) return 0;
        if(s.length() == 0 || s.length() == 1) return s.length();
        int max = 0;
        for(int i=0; i<s.length(); i++) {
            int j=i;
            while(j <= s.length()) {
                String sub = s.substring(i, j);
                Set<Character> set = new HashSet();
                for(char ch : sub.toCharArray()) set.add(ch);
                if(set.size() <= k) max = Math.max(max, sub.length());
                j++;
            }
        }
        return max;
    }
}
