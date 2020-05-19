package LeetCode.HashMap;

import java.util.Arrays;

public class LeetCode567 {
    // Sliding window solution
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        for(char ch : s1.toCharArray()) {
            s1Count[ch - 'a']++;
        }
        for(int i=0; i<s2.length(); i++) {
            char ch = s2.charAt(i);
            s2Count[ch - 'a']++;
            if(i >= s1.length()) {
                char removed = s2.charAt(i - s1.length());
                s2Count[removed - 'a']--;
            }
            if(Arrays.equals(s1Count, s2Count)) return true;
        }
        return false;
    }
}
