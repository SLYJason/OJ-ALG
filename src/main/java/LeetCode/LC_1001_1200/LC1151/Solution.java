package LeetCode.LC_1001_1200.LC1151;

/**
 * Solution: sliding window.
 */
public class Solution {
    public int minSwaps(int[] data) {
        int n = data.length, ones = 0;
        for(int d : data) if(d == 1) ones++;
        if(ones == 1) return 0; // corner case.
        // sliding window logic.
        int i = 0, j = 0, windowOnes = 0;
        int swap = Integer.MAX_VALUE;
        while(j < n) {
            windowOnes += data[j];
            if(j >= ones) {
                windowOnes -= data[i++];
            }
            j++;
            swap = Math.min(ones - windowOnes, swap);
        }
        return swap;
    }
}
