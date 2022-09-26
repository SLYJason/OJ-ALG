package LeetCode.LC_801_1000.LC907;

/**
 * Solution 1: brute force - TLE.
 */
public class Solution_1 {
    public int sumSubarrayMins(int[] arr) {
        int mod = 1_000_000_007;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            for (int j = i; j < arr.length; j++) {
                min = Math.min(min, arr[j]);
                sum = (sum + min) % mod;
            }
        }
        return sum;
    }
}
