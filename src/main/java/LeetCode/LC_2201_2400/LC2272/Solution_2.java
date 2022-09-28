package LeetCode.LC_2201_2400.LC2272;

import java.util.Set;
import java.util.HashSet;

/**
 * Solution 2:
 */
public class Solution_2 {
    public int largestVariance(String s) {
        if (s == null || s.length() <= 2) return 0;
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) set.add(c);

        int res = 0;
        for (char a : set) {
            for (char b : set) {
                if (b == a) continue; // a and b are same characters, not meet the requirement, skip.
                int variance = 0, variance_with_b = -s.length(); // variance: variance between a and b, variance_with_b: variance between a and b but it includes b.

                for (int ch : s.toCharArray()) {
                    if (ch == a) {
                        variance++;
                        variance_with_b++;
                    } else if (ch == b) {
                        variance_with_b = --variance;
                        variance = Math.max(variance, 0);
                    }
                    res = Math.max(res, variance_with_b);
                }
            }
        }
        return res;
    }
}
