package LeetCode.LC_1_200.LC151;

/**
 * Solution: two-pointers.
 */
public class Solution {
    public String reverseWords(String s) {
        StringBuilder reversed = new StringBuilder();
        for(int start=s.length()-1; start>-1; start--) {
            if (s.charAt(start) == ' ') continue;
            int end = start;
            while(start > -1 && s.charAt(start) != ' ') start--;
            reversed.append(s.substring(start+1, end+1)).append(" ");
        }
        return reversed.toString().trim();
    }
}
