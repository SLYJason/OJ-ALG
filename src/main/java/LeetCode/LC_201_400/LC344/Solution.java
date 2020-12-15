package LeetCode.LC_201_400.LC344;

/**
 * Solution: two pointers.
 */
public class Solution {
    public void reverseString(char[] s) {
        for(int i=0, j=s.length-1; i<j; i++, j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }
}
