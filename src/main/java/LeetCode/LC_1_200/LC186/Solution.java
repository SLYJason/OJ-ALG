package LeetCode.LC_1_200.LC186;

/**
 * Solution: two-pointers.
 */
public class Solution {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length-1);
        for(int start=0; start<s.length; start++) {
            int end = start;
            while(end<s.length && s[end] != ' ') end++;
            reverse(s, start, end-1);
            start=end;
        }

    }

    private void reverse(char[] s, int start, int end) {
        while(start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}
