package LeetCode.LC_601_800.LC727;

/**
 * Solution: two pointers.
 */
public class Solution {
    public String minWindow(String S, String T) {
        if(S.length() == 0 || T.length() == 0) return "";
        if(S.length() < T.length()) return "";

        char[] s = S.toCharArray(), t = T.toCharArray();
        int s_idx = 0, t_idx = 0, s_len = S.length(), t_len = T.length();
        int min_length = Integer.MAX_VALUE, start = -1;

        while(s_idx < s_len) {
            if(s[s_idx] == t[t_idx]) {
                t_idx++;
                if(t_idx == t_len) { // find a match, i.e. subsequence found in S.
                    int end = s_idx + 1;
                    t_idx--;
                    while(t_idx >= 0) { // go back to find minimum matched length.
                        if(s[s_idx] == t[t_idx]) {
                            t_idx--;
                        }
                        s_idx--;
                    }
                    s_idx++;
                    t_idx++;
                    if(end - s_idx < min_length) {
                        start = s_idx;
                        min_length = end - s_idx;
                    }
                }
            }
            s_idx++;
        }
        return start == -1 ? "" : S.substring(start, start + min_length);
    }
}
