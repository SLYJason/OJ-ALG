package LeetCode.DynamicProgramming;

/**
 * Solution 1: expand to left and right same time from the center.
 */
public class LeetCode5_Sol1 {
    String max_string = "";
    public String longestPalindrome(String s) {
        for(int i=0; i<s.length(); i++) {
            checkPalindromic(s, i, i);
            checkPalindromic(s, i, i+1);
        }
        return max_string;
    }

    private void checkPalindromic(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if(right-left+1 > max_string.length()) {
                max_string = s.substring(left, right+1);
            }
            left--;
            right++;
        }
    }
}
