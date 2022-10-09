package LeetCode.LC_401_600.LC528;

import java.util.Random;

/**
 * Solution 1: linear search.
 */
public class Solution_1 {
    class Solution {
        int weights;
        int[] prefixSum;
        public Solution(int[] w) {
            prefixSum = new int[w.length];
            int sum = 0;
            for (int i = 0; i < w.length; i++) {
                sum += w[i];
                prefixSum[i] = sum;
            }
            weights = sum;
        }

        public int pickIndex() {
            int rand = new Random().nextInt(weights);
            int sum = 0;
            for (int i = 0; i < prefixSum.length; i++) {
                if (rand < prefixSum[i]) return i;
            }
            return prefixSum.length - 1;
        }
    }
}
