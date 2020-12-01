package LeetCode.LC_1_200.LC5;

/**
 * Solution 2: expand from center.
 */
public class Solution_2 {
    int start = 0, max_length = Integer.MIN_VALUE;
    public String longestPalindrome(String s) {
        for(int i=0; i<s.length(); i++) {
            checkPalindromeLength(i, i, s);
            checkPalindromeLength(i, i+1, s);
        }
        return s.substring(start, start + max_length);
    }

    private void checkPalindromeLength(int left, int right, String s) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if(right - left + 1 > max_length) {
                max_length = right - left + 1;
                start = left;
            }
            left--;
            right++;
        }
    }
}
