package LeetCode.LC_1_200.LC131;

import java.util.List;
import java.util.ArrayList;

/**
 * Solution 1: backtrack.
 */
public class Solution_1 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList();
        dfs(0, s, new ArrayList(), res);
        return res;
    }

    private void dfs(int start, String s, List<String> list, List<List<String>> res) {
        if(start == s.length()) {
            res.add(new ArrayList(list));
            return;
        }
        for(int end=start; end<s.length(); end++) {
            if(isPalindrome(s, start, end)) {
                list.add(s.substring(start, end+1));
                dfs(end+1, s, list, res);
                list.remove(list.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}
