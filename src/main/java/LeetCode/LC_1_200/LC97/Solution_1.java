package LeetCode.LC_1_200.LC97;

/**
 * Solution: brute force.
 * Time Complexity: O(2^(m+n)). m is s1 length, n is s2 length.
 * Space Complexity: O(m + n).
 */
public class Solution_1 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false; // base case.
        return isInterleave(0, 0, 0, s1.toCharArray(), s2.toCharArray(), s3.toCharArray());
    }

    private boolean isInterleave(int i, int j, int k, char[] c1, char[] c2, char[] c3) {
        if(k == c3.length) return true;
        boolean valid = false;
        if(i < c1.length) valid = valid || c1[i] == c3[k] && isInterleave(i+1, j, k+1, c1, c2, c3);
        if(j < c2.length) valid = valid || c2[j] == c3[k] && isInterleave(i, j+1, k+1, c1, c2, c3);
        return valid;
    }
}
