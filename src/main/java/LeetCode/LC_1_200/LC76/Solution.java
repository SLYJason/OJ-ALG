package LeetCode.LC_1_200.LC76;

/**
 * Solution: sliding window.
 */
public class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        int[] t_count = new int[128];
        for(char ch : t.toCharArray()) t_count[ch]++;

        String res = ""; // final result.
        int distance = 0; // distance used to measure numer of t's characters in window.
        int min_len = Integer.MAX_VALUE; // minimum window length.
        int i = 0, j = 0;
        int[] window = new int[128];
        while(j < s.length()) {
            char c = s.charAt(j);
            window[c]++;
            if(window[c] <= t_count[c]) distance++;

            // contract the window.
            while(distance == t.length()) {
                if(j-i+1 < min_len) {
                    min_len = j-i+1;
                    res = s.substring(i, j+1);
                }
                if(window[s.charAt(i)] == t_count[s.charAt(i)]) distance--;
                window[s.charAt(i)]--;
                i++;
            }
            j++;
        }
        return res;
    }
}
