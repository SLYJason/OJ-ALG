package LeetCode.LC_1001_1200.LC1177;

import java.util.List;
import java.util.ArrayList;

/**
 * Solution: prefix sum.
 */
public class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int n = s.length();
        int[][] count = new int[n + 1][26];
        for(int i=0; i<n; i++) {
            int c = s.charAt(i) - 'a';
            for(int j=0; j<26; j++) {
                count[i+1][j] = count[i][j];
            }
            count[i+1][c]++;
        }

        List<Boolean> res = new ArrayList<>();
        for(int[] q : queries) {
            int left = q[0], right = q[1], k = q[2], odds = 0;
            for(int i=0; i<26; i++) {
                odds += (count[right+1][i] - count[left][i]) % 2;
            }
            res.add(odds / 2 <= k);
        }
        return res;
    }
}
