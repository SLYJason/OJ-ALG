package LeetCode.LC_201_400.LC301;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution: DFS.
 */
public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        // step 1: calculate the minimum number of left parentheses and right parentheses need to be removed.
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') left++;
            if (s.charAt(i) == ')') {
                if (left == 0) {
                    right++;
                } else {
                    left--;
                }
            }
        }

        // step 2: try to remove left and right and check the rest of the string is valid.
        dfs(s, 0, left, right, res);
        return res;
    }

    private void dfs(String s, int start, int left, int right, List<String> res) {
        // nothing to remove.
        if (left == 0 && right == 0 && isValid(s)) {
            res.add(s);
            return;
        }
        for (int i = start; i < s.length(); i++) {
            // deduplication: only remove the first parentheses if there are consecutive ones to avoid duplications.
            // For example: (((()) remove any ( in the first 4 parentheses has same result ((()).
            if (i != start && s.charAt(i) == s.charAt(i - 1)) continue;

            // optional.
            if (left + right > s.length() - i) return;

            String removed = s.substring(0, i) + s.substring(i + 1);
            // remove left parentheses.
            if (left > 0 && s.charAt(i) == '(') {
                dfs(removed, i, left - 1, right, res);
            }
            // remove right parentheses.
            if (right > 0 && s.charAt(i) == ')') {
                dfs(removed, i, left, right - 1, res);
            }
        }
    }

    private boolean isValid(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') count++;
            if (str.charAt(i) == ')') count--;
            if (count < 0) return false;
        }
        return count == 0;
    }
}
