package LeetCode.DynamicProgramming;

/**
 * Solution 1: expand to left and right same time from the center.
 */
public class LeetCode647_Sol1 {
    int count = 0;
    public int countSubstrings(String s) {
        for(int i=0; i<s.length(); i++) {
            checkPalindromic(s, i, i);
            checkPalindromic(s, i, i+1);
        }
        return count;
    }
    private void checkPalindromic(String s, int left, int right) {
        while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }
}
