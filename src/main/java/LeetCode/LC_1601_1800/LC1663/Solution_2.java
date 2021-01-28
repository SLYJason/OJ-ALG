package LeetCode.LC_1601_1800.LC1663;

import java.util.Arrays;

/**
 * Solution 2: greedy build from right to left.
 */
public class Solution_2 {
    public String getSmallestString(int n, int k) {
        char[] res = new char[n];
        Arrays.fill(res, 'a');
        k -= n;
        for(int i=n-1; i>=0 && k>0; i--) {
            int cur = Math.min(k, 25);
            res[i] += cur;
            k -= cur;
        }
        return new String(res);
    }
}
