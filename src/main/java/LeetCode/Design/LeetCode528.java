package LeetCode.Design;

import java.util.Random;

public class LeetCode528 {
    class Solution {
        int sum;
        int[] weights;
        public Solution(int[] w) {
            sum = 0;
            for(int weight : w) sum += weight;
            weights = w;
        }

        public int pickIndex() {
            int currSum = 0;
            int random = new Random().nextInt(sum);
            for(int i=0; i<weights.length; i++) {
                currSum += weights[i];
                if(currSum > random) return i;
            }
            return -1;
        }
    }
}
