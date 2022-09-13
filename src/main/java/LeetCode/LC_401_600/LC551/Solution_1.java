package LeetCode.LC_401_600.LC551;

/**
 * Solution: single pass.
 */
public class Solution_1 {
    public boolean checkRecord(String s) {
        int i = 0, absent = 0;
        while (i < s.length()) {
            if (s.charAt(i) == 'A') {
                absent++;
            }
            if (absent > 1) return false;
            if (s.charAt(i) == 'L') {
                int j = i;
                while (j < s.length() && s.charAt(j) == 'L') j++;
                if (j - i > 2) return false;
                i = j - 1;
            }
            i++;
        }
        return true;
    }
}
