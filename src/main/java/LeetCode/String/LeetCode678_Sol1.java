package LeetCode.String;

// Solution 1: brute force using recursive, check all possible string for each *
public class LeetCode678_Sol1 {
    public boolean checkValidString(String s) {
        return isValid(s, 0, 0);
    }

    private boolean isValid(String str, int pos, int open) {
        if(pos == str.length()) return open == 0;
        if(open < 0) return false;
        char ch = str.charAt(pos);
        if(ch == '(') {
            open++;
            return isValid(str, pos+1, open);
        } else if (ch == ')') {
            return isValid(str, pos+1, open-1);
        } else {
            return isValid(str, pos+1, open) || isValid(str, pos+1, open+1) || isValid(str, pos+1, open-1);
        }
    }
}
