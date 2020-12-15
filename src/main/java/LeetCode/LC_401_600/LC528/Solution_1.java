package LeetCode.LC_401_600.LC528;

import java.util.Random;

/**
 * Solution: linear search.
 */
public class Solution_1 {
    class Solution {
        int weights;
        int[] w;
        public Solution(int[] w) {
            for(int weight : w) weights += weight;
            this.w = w;
        }

        public int pickIndex() {
            int rand = new Random().nextInt(weights);
            int sum = 0;
            for(int i=0; i<w.length; i++) {
                sum += w[i];
                if(sum > rand) return i;
            }
            return w.length-1;
        }
    }
}
