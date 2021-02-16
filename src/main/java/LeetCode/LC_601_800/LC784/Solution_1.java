package LeetCode.LC_601_800.LC784;

import java.util.List;
import java.util.ArrayList;

/**
 * Solution 1: backtrack.
 */
public class Solution_1 {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        res.add(S);
        backtrack(0, new StringBuilder(S), res);
        return res;
    }

    private void backtrack(int start, StringBuilder sb, List<String> res) {
        if(start == sb.length()) return;
        for(int i=start; i<sb.length(); i++) {
            char c = sb.charAt(i);
            if(Character.isAlphabetic(c)) {
                char toggle = (char)(c ^ (1 << 5)); // trick to toggle case.
                sb.setCharAt(i, toggle);
                res.add(sb.toString());
                backtrack(i + 1, sb, res);
                sb.setCharAt(i, c);
            }
        }
    }
}
