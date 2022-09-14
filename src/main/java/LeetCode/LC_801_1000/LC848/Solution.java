package LeetCode.LC_801_1000.LC848;

/**
 * Solution: postfix sum.
 */
public class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n = shifts.length;
        for (int i = n - 2; i >= 0; i--) {
            shifts[i] = (shifts[i] + shifts[i + 1]) % 26;
        }

        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < n; i++) {
            int shifted = (sb.charAt(i) + shifts[i] - 'a') % 26 + 'a';
            sb.setCharAt(i, (char)shifted);
        }
        return sb.toString();
    }
}
