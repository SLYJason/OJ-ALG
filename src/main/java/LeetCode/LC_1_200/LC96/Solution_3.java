package LeetCode.LC_1_200.LC96;

/**
 * Solution 3: catalan number.
 */
public class Solution_3 {
    public int numTrees(int n) {
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }
}
