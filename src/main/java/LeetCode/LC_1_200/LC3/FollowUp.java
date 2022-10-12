package LeetCode.LC_1_200.LC3;

import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class FollowUp {
    public static List<String> getLongestSubstring(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() <= 1) {
            res.add(s);
            return res;
        }

        // step 1: find length of the longest substring without repeating characters.
        char[] S = s.toCharArray();
        int i = 0, j = 0, max_length = 0;
        Set<Character> window = new HashSet<>();
        while (j < s.length()) {
            if (!window.contains(S[j])) {
                window.add(S[j++]);
                max_length = Math.max(max_length, window.size());
            } else {
                window.remove(S[i++]);
            }
        }

        // step 2: build the result.
        i = 0;
        j = 0;
        window.clear();
        while (j < s.length()) {
            if (!window.contains(S[j])) {
                window.add(S[j++]);
            } else {
                window.remove(S[i++]);
            }
            if (window.size() == max_length) {
                res.add(s.substring(i, j));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        System.out.println(getLongestSubstring(s1));

        String s2 = "ccc";
        System.out.println(getLongestSubstring(s2));
    }
}
