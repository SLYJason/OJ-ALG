package LeetCode.String;

/**
 * Solution 1: iterative solution.
 */
public class LeetCode680_Sol1 {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length()-1;
        while(left < right && s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
        }
        return isPalindrome(s, left+1, right) || isPalindrome(s, left, right-1);
    }

    private boolean isPalindrome(String s, int i, int j) {
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
