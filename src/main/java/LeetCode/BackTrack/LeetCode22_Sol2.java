package LeetCode.BackTrack;

import java.util.List;
import java.util.LinkedList;

/**
 * Solution 2: backtrack.
 */
public class LeetCode22_Sol2 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList();
        backtrack("", n, n, res);
        return res;
    }

    private void backtrack(String curr, int open, int close, List<String> res) {
        if(open == 0 && close == 0) {
            res.add(curr);
            return;
        }
        if(open > 0) {
            backtrack(curr + "(", open-1, close, res);
        }
        if(open < close) {
            backtrack(curr + ")", open, close-1, res);
        }
    }
}
