package LeetCode.LC_401_600.LC552;

/**
 * Solution 1: brute force - TLE.
 */
public class Solution_1 {
    int res = 0;

    public int checkRecord(int n) {
        StringBuilder sb = new StringBuilder();
        dfs(sb, n);
        return res;
    }

    private void dfs(StringBuilder sb, int n) {
        if (sb.length() == n) {
            res = isValid(sb.toString()) ? res + 1 : res;
            return;
        }
        dfs(sb.append("A"), n);
        sb.setLength(sb.length() - 1);
        dfs(sb.append("L"), n);
        sb.setLength(sb.length() - 1);
        dfs(sb.append("P"), n);
        sb.setLength(sb.length() - 1);
    }

    private boolean isValid(String s) {
        return !s.matches(".*(A.*A|LLL).*");
    }
}
