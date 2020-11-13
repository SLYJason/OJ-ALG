package LeetCode.LC_1001_1200.LC1099;

import java.util.Arrays;

/**
 * Solution 2: sorting.
 */
public class Solution_2 {
    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
        int sum = -1;
        int i=0, j=A.length-1;
        while(i < j) {
            if(A[i] + A[j] < K) {
                sum = Math.max(sum, A[i] + A[j]);
                i++;
            } else {
                j--;
            }
        }
        return sum;
    }
}
