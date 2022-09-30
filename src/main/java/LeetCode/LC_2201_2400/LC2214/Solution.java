package LeetCode.LC_2201_2400.LC2214;

/**
 * Solution: one pass.
 */
public class Solution {
    public long minimumHealth(int[] damage, int armor) {
        long damages = 0;
        int max = damage[0];
        for (int d : damage) {
            damages += d;
            max = Math.max(max, d);
        }
        if (armor >= max) return damages - max + 1;
        return damages - armor + 1;
    }
}
