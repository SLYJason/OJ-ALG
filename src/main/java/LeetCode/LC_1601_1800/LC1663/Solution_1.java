package LeetCode.LC_1601_1800.LC1663;

/**
 * Solution 1: greedy build from left to right.
 */
public class Solution_1 {
    public String getSmallestString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            int rest = n - 1 - i;
            if(k > rest * 26) {
                int cur = k - rest * 26;
                sb.append((char)('a' + cur - 1));
                k -= cur;
            } else {
                sb.append('a');
                k -= 1;
            }
        }
        return sb.toString();
    }
}
