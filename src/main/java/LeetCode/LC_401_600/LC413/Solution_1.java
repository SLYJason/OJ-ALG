package LeetCode.LC_401_600.LC413;

/**
 * Solution 1: brute force.
 */
public class Solution_1 {
    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length, count = 0;
        for(int i=0; i<n-2; i++) {
            int diff = A[i+1] - A[i];
            int j = i+2;
            while(j < n && diff == A[j] - A[j-1]) {
                j++;
            }
            count += j - i >= 2 ? (j - i - 2) : 0;
        }
        return count;
    }
}
