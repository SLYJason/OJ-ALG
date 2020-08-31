package LeetCode.BackTrack;

import java.util.List;
import java.util.LinkedList;

/**
 * Solution 1: brute force, generate all possible combinations and check if anyone is valid.
 */
public class LeetCode22_Sol1 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList();
        generateAll("", n, n, res);
        return res;
    }

    private void generateAll(String curr, int open, int close, List<String> res) {
        if(open != 0 && close == 0) return;
        if(open == 0 && close == 0 && isValid(curr)) {
            res.add(curr);
            return;
        }
        if(open == 0) {
            while(close-- > 0) curr += ")";
            if(isValid(curr)) res.add(curr);
        } else {
            generateAll(curr + "(", open-1, close, res);
            generateAll(curr + ")", open, close-1, res);
        }
    }

    private boolean isValid(String str) {
        int balance = 0;
        for(char ch : str.toCharArray()) {
            if(ch == '(') {
                balance++;
            } else {
                balance--;
            }
            if(balance < 0) return false;
        }
        return true;
    }
}
