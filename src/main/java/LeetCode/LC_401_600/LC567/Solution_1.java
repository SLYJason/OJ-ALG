package LeetCode.LC_401_600.LC567;

import java.util.Arrays;

/**
 * Solution 1: sliding window - fixed window size.
 */
public class Solution_1 {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int[] s1_count = new int[26];
        for(char ch : s1.toCharArray()) s1_count[ch - 'a']++;

        int[] s2_count = new int[26];
        for(int i=0, j=0; j<s2.length(); j++) {
            if(j >= s1.length()) {
                s2_count[s2.charAt(i) - 'a']--;
                i++;
            }
            s2_count[s2.charAt(j) - 'a']++;
            if(Arrays.equals(s1_count, s2_count)) return true;
        }
        return false;
    }
}
