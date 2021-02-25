package LeetCode.LC_801_1000.LC856;

/**
 * Solution 1: recursion.
 */
public class Solution_1 {
    public int scoreOfParentheses(String S) {
        return score(S.toCharArray(), 0, S.length()-1);
    }

    private int score(char[] s, int l, int r) {
        if(r - l == 1) return 1;
        int balance = 0;
        for(int i=l; i<r; i++) {
            if(s[i] == '(') balance++;
            if(s[i] == ')') balance--;
            if(balance == 0) {
                return score(s, l, i) + score(s, i+1, r); // part of the string is balanced, eg. "(A)(B)".
            }
        }
        return 2 * score(s, l+1, r-1); // the whole string is balanced, so remove the outer parentheses and check inner string score, eg. "(A)".
    }
}
