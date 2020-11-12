package LeetCode.LC_1_200.LC93;

import java.util.List;
import java.util.ArrayList;

/**
 * Solution: backtrack.
 */
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        if(s == null || s.length() < 4 || s.length() > 12) return new ArrayList(); // base case.
        List<String> res = new ArrayList();
        dfs(0, s, 3, new StringBuilder(), res);
        return res;
    }

    private void dfs(int start, String s, int dots, StringBuilder sb, List<String> res) {
        if(dots < 0 && start == s.length()) {
            sb.deleteCharAt(sb.length()-1); // we added one more dot, so need to remove it.
            res.add(sb.toString());
            return;
        }

        for(int end=start; end<s.length(); end++) {
            String sub = s.substring(start, end+1);
            int num = parse(sub);

            if(num >= 0 && num <= 255 && dots >= 0) {
                int len = sb.length();
                sb.append(num).append(".");
                dfs(end+1, s, dots-1, sb, res);
                sb.setLength(len);
            }
        }
    }

    private int parse(String s) {
        if(s.length() > 1 && s.charAt(0) == '0') return -1; // avoid leading zero.
        try {
            Integer num = Integer.valueOf(s);
            return num;
        } catch (NumberFormatException e) {} // if the number exceeds MAX_VALUE, need to throw exception.
        return -1;
    }
}
