package LeetCode.LC_2201_2400.LC2272;

/**
 * Solution 1: brute force - TLE.
 */
public class Solution_1 {
    public int largestVariance(String s) {
        if (s == null || s.length() <= 2) return 0;
        int n = s.length(), variance = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String sub = s.substring(i, j);
                int[] count = new int[26];
                int min = j - i, max = 0;
                for (char c : sub.toCharArray()) count[c - 'a']++;
                for (int c : count) {
                    if (c == 0) continue;
                    min = Math.min(min, c);
                    max = Math.max(max, c);
                }
                variance = Math.max(variance, max - min);
            }
        }
        return variance;
    }
}
