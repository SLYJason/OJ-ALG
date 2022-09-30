package LeetCode.LC_2201_2400.LC2262;

/**
 * Solution: DP.
 */
public class Solution {
    public long appealSum(String s) {
        if (s == null) return 0;
        if (s.length() <= 1) return s.length();

        long res = 0;
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i + 1;
            for (int n : last) {
                res += n;
            }
        }

        return res;
    }
}
