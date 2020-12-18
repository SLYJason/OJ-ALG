package LeetCode.LC_601_800.LC680;

/**
 * Follow Up.
 */
public class FollowUp {
    public boolean validPalindrome(String s) {
        return isPalindrome(s, 0, s.length()-1, 1); // d means the number of characters can be deleted
    }

    private boolean isPalindrome(String s, int i, int j, int d) {
        if(i >= j) return true;
        if(s.charAt(i) == s.charAt(j)) {
            return isPalindrome(s, i+1, j-1, d);
        } else {
            return d > 0 && (isPalindrome(s, i+1, j, d-1) || isPalindrome(s, i, j-1, d-1));
        }
    }
}
