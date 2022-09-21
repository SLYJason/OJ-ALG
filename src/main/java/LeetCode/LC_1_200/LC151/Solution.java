package LeetCode.LC_1_200.LC151;

/**
 * Solution: two-pointers.
 */
public class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = s.length()-1; i > -1; i--) {
            if (s.charAt(i) == ' ') continue;
            int j = i;
            while (i > -1 && s.charAt(i) != ' ') i--;
            sb.append(s, i + 1, j + 1).append(" ");
        }
        return sb.toString().trim();
    }
}
