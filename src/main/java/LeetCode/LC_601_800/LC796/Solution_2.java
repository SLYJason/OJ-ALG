package LeetCode.LC_601_800.LC796;

/**
 * Solution 2: one liner.
 */
public class Solution_2 {
    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }
}
