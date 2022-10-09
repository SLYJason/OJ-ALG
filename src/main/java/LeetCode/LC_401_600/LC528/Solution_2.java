package LeetCode.LC_401_600.LC528;

import java.util.Random;

/**
 * Solution 2: binary search.
 */
public class Solution_2 {
    class Solution {
        int weights;
        int[] w;
        public Solution(int[] w) {
            for(int i = 1; i < w.length; i++) w[i] += w[i - 1];
            this.w = w;
        }

        public int pickIndex() {
            int rand = new Random().nextInt(w[w.length - 1]) + 1; // give the random range start from 1 (inclusive).
            int left = 0, right = w.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (w[mid] == rand) return mid;
                if (w[mid] < rand) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }
    }
}
