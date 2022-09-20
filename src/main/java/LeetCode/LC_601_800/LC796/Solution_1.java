package LeetCode.LC_601_800.LC796;

/**
 * Solution 1: brute force.
 */
public class Solution_1 {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        for (int i = 0; i < s.length(); i++) {
            String shift = s.substring(i) + s.substring(0, i);
            if (shift.equals(goal)) return true;
        }
        return false;
    }
}
