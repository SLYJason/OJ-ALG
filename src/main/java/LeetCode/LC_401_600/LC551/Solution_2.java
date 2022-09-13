package LeetCode.LC_401_600.LC551;

/**
 * Solution 2: regex.
 */
public class Solution_2 {
    public boolean checkRecord(String s) {
        return !s.matches(".*(A.*A|LLL).*");
    }
}
