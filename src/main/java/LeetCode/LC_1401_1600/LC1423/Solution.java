package LeetCode.LC_1401_1600.LC1423;

import java.util.Arrays;

/**
 * Solution: sliding window.
 */
public class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = Arrays.stream(cardPoints).sum();
        if(k == cardPoints.length) return sum; // base case.

        int window_size = cardPoints.length - k;
        int window_sum = 0, min = Integer.MAX_VALUE;
        for(int i=0, j=0; i<cardPoints.length; i++) {
            window_sum += cardPoints[i];
            if(i - j + 1 == window_size) {
                min = Math.min(min, window_sum);
                window_sum -= cardPoints[j++];
            }
        }
        return sum - min;
    }
}
